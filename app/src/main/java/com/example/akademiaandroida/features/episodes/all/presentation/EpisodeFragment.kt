package com.example.akademiaandroida.features.episodes.all.presentation

import android.view.View
import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    override fun onIdleState() {
        super.onIdleState()
        episode_progressBar.visibility = View.INVISIBLE
    }

    override fun onPendingState() {
        super.onPendingState()
        episode_progressBar.visibility = View.VISIBLE
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    private fun setupRecyclerView() {
        recycler_view_episodes.adapter = adapter
        adapter.listener = { viewModel.onEpisodeClick(it) }
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            adapter.setEpisodes(it)
        }
    }


}