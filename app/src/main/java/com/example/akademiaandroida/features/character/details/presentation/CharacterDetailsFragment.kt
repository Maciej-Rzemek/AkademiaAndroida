package com.example.akademiaandroida.features.character.details.presentation

import android.os.Bundle
import com.example.akademiaandroida.BR
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "character_details_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterDataPassed(it) }
    }

}