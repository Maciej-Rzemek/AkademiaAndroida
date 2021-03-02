package com.example.akademiaandroida.features.location.all.presentation

import android.view.View
import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.location_fragment.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.location_fragment) {


    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    override fun onIdleState() {
        super.onIdleState()
        location_progressBar.visibility = View.INVISIBLE
    }

    override fun onPendingState() {
        super.onPendingState()
        location_progressBar.visibility = View.VISIBLE
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    private fun setupRecyclerView() {
        recycler_view_location.adapter = adapter
        adapter.listener = { viewModel.onLocationClick(it) }
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            adapter.setLocations(it)
        }
    }


}