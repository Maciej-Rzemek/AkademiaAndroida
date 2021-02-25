package com.example.akademiaandroida.features.character.presentation

import androidx.lifecycle.observe
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.character_fragment) {

    override val viewModel: CharacterViewModel by viewModel()

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
        observeCharacters()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            // code to display characters
        }
    }
}