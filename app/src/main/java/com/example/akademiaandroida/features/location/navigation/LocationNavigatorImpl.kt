package com.example.akademiaandroida.features.location.navigation

import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.akademiaandroida.features.location.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : LocationNavigator {

    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_locations_screen_to_locations_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }


}