package com.example.akademiaandroida.features.location.presentation

import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.location_fragment) {


    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        //initialize all views classes
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state here
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            // code to display locations
        }
    }


}