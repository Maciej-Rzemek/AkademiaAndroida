package com.example.akademiaandroida.features.location.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.UiState
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.features.location.all.presentation.LocationViewModel
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.akademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.akademiaandroida.features.location.domain.model.Location
import com.example.akademiaandroida.features.location.navigation.LocationNavigator
import com.example.akademiaandroida.mock.mock
import com.example.akademiaandroida.utils.ViewModelTest
import com.example.akademiaandroida.utils.getOrAwaitValue
import com.example.akademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location is clicked THEN open episode details screen`() {
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel =
            LocationViewModel(
                useCase,
                locationNavigator,
                errorMapper
            )
        val location = LocationDisplayable.mock()

        //when
        viewModel.onLocationClick(location)

        //then
        verify { locationNavigator.openLocationDetailsScreen(location) }
    }

    @Test
    fun `WHEN location liveData is observed THEN set pending state`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel =
            LocationViewModel(
                useCase,
                locationNavigator,
                errorMapper
            )

        //when
        viewModel.locations.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN location liveData is observed THEN invoke use case to get location`() {
        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel =
            LocationViewModel(
                useCase,
                locationNavigator,
                errorMapper
            )

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }


    @Test
    fun `GIVEN use case result is success WHEN location liveData is observed THEN set idle state AND set result in liveData`() {

        //given
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val viewModel =
            LocationViewModel(
                useCase,
                locationNavigator,
                errorMapper
            )

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.type shouldBe location.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        // given
        val throwable = Throwable("Oops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel =
            LocationViewModel(
                useCase,
                locationNavigator,
                errorMapper
            )

        // when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        // then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }

}