package com.example.akademiaandroida.features.location.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.jupiter.api.Test

internal class GetLocationsUseCaseTest {

    @Test
    fun `when use case is invoked then execute getLocations method from repository`() {
        // given
        val repository = mockk<LocationsRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        //when
        useCase(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify {
            repository.getLocations()
        }
    }

}