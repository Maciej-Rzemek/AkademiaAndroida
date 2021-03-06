package com.example.akademiaandroida.features.location.details.presentation

import android.os.Bundle
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.FragmentEpisodeBinding
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel, FragmentEpisodeBinding>(
        BR.viewModel,
        R.layout.fragment_location_details
    ) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "location_details_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutLocationData()
    }

    private fun notifyAboutLocationData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationDataPassed(it) }
    }
}