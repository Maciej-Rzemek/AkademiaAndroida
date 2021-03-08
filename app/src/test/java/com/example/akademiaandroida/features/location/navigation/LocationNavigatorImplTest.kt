package com.example.akademiaandroida.features.location.navigation

import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.akademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationNavigatorImplTest {

    @Test
    fun `WHEN openLocationsDetailsScreen is called THEN invoke navigateTo method with appropriate action and location model as argument`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_locations_screen_to_locations_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        fragmentNavigator.goBack()

        //then
        verify { fragmentNavigator.goBack() }
    }
}