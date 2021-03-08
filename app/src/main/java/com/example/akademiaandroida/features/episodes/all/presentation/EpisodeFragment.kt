package com.example.akademiaandroida.features.episodes.all.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.FragmentEpisodeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : BaseFragment<EpisodeViewModel, FragmentEpisodeBinding>(
    BR.viewModel, R.layout.fragment_episode
) {

    override val viewModel: EpisodeViewModel by viewModel()
    private val episodeAdapter: EpisodeAdapter by inject()
    private val divider: DividerItemDecoration by inject()

    override fun initViews(binding: FragmentEpisodeBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    override fun onDestroyView() {
        binding?.recyclerViewEpisodes?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.recyclerViewEpisodes) {
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
        episodeAdapter.setOnEpisodeClickListener { viewModel.onEpisodeClick(it) }
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            episodeAdapter.setItems(it)
        }
    }
}