package com.example.akademiaandroida.features.location.all.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.BaseViewModel
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.akademiaandroida.features.location.domain.GetLocationsUseCase
import com.example.akademiaandroida.features.location.domain.model.Location
import com.example.akademiaandroida.features.location.navigation.LocationNavigator

class LocationViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocations(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map {
                LocationDisplayable(
                    it
                )
            }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onLocationClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }
}