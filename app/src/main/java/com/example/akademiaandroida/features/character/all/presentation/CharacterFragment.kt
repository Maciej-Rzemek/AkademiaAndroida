package com.example.akademiaandroida.features.character.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.character_fragment.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.character_fragment) {

    override val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun initViews() {
        super.initViews()
        setupRecyclerView()
    }

    override fun onPendingState() {
        super.onPendingState()
        character_progressBar.visibility = View.VISIBLE
    }

    override fun onIdleState() {
        super.onIdleState()
        character_progressBar.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView() {
        recycler_view_characters.adapter = adapter
        recycler_view_characters.layoutManager = get<GridLayoutManager>()
        adapter.listener = { viewModel.onCharacterClick(it) }
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            adapter.setCharacters(it)
        }
    }
}