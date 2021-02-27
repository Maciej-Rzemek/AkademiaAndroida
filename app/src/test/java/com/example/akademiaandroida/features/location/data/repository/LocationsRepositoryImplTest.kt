package com.example.akademiaandroida.features.location.data.repository

import com.example.akademiaandroida.core.api.RickAndMortyApi
import com.example.akademiaandroida.core.api.model.locations.LocationsResponse
import com.example.akademiaandroida.core.exeption.ErrorWrapper
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.features.location.data.local.LocationsDao
import com.example.akademiaandroida.features.location.data.local.model.LocationsCached
import com.example.akademiaandroida.features.location.domain.LocationsRepository
import com.example.akademiaandroida.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class LocationsRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {

        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val locationsDao = mockk<LocationsDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationsDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        //given
        val api = mockk<RickAndMortyApi>() {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val locationsDao = mockk<LocationsDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationsDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        coVerify { locationsDao.saveLocations(*anyVararg()) }
    }


    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationsDao = mockk<LocationsDao> {
            coEvery { getLocations() } returns listOf(
                LocationsCached.mock(),
                LocationsCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)

        val repository: LocationsRepository =
            LocationsRepositoryImpl(api, locationsDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationsDao.getLocations() }
    }
}