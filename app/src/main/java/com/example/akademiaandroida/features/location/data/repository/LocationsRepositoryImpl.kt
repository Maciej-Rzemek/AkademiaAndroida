package com.example.akademiaandroida.features.location.data.repository

import com.example.akademiaandroida.core.api.RickAndMortyApi
import com.example.akademiaandroida.core.exeption.ErrorWrapper
import com.example.akademiaandroida.core.exeption.callOrThrow
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.features.location.data.local.LocationsDao
import com.example.akademiaandroida.features.location.data.local.model.LocationsCached
import com.example.akademiaandroida.features.location.domain.LocationsRepository
import com.example.akademiaandroida.features.location.domain.model.Location

class LocationsRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationsDao: LocationsDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : LocationsRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getLocationsFromRemote()
            }
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations()
            .results
            .map { it.toLocation() }
            .also { saveLocationsToLocal(it) }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationsCached(it) }
            .toTypedArray()
            .let { locationsDao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationsDao.getLocations()
            .map { it.toLocation() }
    }

}