package com.example.akademiaandroida.features.character.all.presentation

import androidx.recyclerview.widget.GridLayoutManager
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.CharacterFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel, CharacterFragmentBinding>(
    BR.viewModel,
    R.layout.character_fragment
) {

    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by inject()
    private val gridLayoutManager: GridLayoutManager by inject()

    override fun initViews(binding: CharacterFragmentBinding) {
        super.initViews(binding)
        initRecycler(binding)
    }

    private fun initRecycler(binding: CharacterFragmentBinding) {
        with(binding.recyclerViewCharacters) {
            setHasFixedSize(true)
            adapter = characterAdapter
            layoutManager = gridLayoutManager
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }

    override fun onDestroyView() {
        binding?.recyclerViewCharacters?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }
}