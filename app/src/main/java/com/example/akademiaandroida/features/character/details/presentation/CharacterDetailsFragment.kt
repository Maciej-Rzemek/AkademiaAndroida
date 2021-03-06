package com.example.akademiaandroida.features.character.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.base.BaseFragment
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "character_details_key"
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.character.observe(this) { displayCharacter(it) }
    }

    private fun displayCharacter(character: CharacterDisplayable) {
        Glide.with(this).load(character.image).into(character_imageview)
        character_name.text = character.name
        character_species.text = character.species
        character_status.text = character.status
        character_origin.text = character.characterOrigin.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutCharacterData()
    }

    private fun notifyAboutCharacterData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterDataPassed(it) }
    }
}