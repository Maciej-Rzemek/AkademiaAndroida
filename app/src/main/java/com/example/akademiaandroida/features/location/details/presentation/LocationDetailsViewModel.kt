package com.example.akademiaandroida.features.location.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.akademiaandroida.core.base.BaseViewModel
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable

class LocationDetailsViewModel : BaseViewModel() {

    private val _location by lazy { MutableLiveData<LocationDisplayable>() }
    val location: LiveData<LocationDisplayable> by lazy { _location }

    fun onLocationDataPassed(locationDisplayable: LocationDisplayable) {
        _location.value = locationDisplayable
    }
}