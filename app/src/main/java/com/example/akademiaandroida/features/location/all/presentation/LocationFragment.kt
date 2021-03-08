package com.example.akademiaandroida.features.location.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.LocationFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel, LocationFragmentBinding>(
    BR.viewModel,
    R.layout.location_fragment
) {

    private val divider: DividerItemDecoration by inject()
    override val viewModel: LocationViewModel by viewModel()
    private val locationAdapter: LocationAdapter by inject()

    override fun initViews(binding: LocationFragmentBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: LocationFragmentBinding) {
        with(binding.recyclerViewLocation) {
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = locationAdapter
        }
        locationAdapter.setOnLocationClickListener { viewModel.onLocationClick(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.recyclerViewLocation?.let {
            it.adapter = null
            it.layoutManager = null
        }
    }
}