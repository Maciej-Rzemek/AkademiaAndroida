package com.example.akademiaandroida.features.location.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "location_details_key"
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.location.observe(this) { displayLocation(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutLocationData()
    }

    private fun displayLocation(locationDisplayable: LocationDisplayable) {
        location_title.text = locationDisplayable.name
        location_dimension.text = locationDisplayable.dimension
    }

    private fun notifyAboutLocationData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationDataPassed(it) }
    }
}