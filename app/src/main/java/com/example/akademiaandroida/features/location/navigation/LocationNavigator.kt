package com.example.akademiaandroida.features.location.navigation

import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}