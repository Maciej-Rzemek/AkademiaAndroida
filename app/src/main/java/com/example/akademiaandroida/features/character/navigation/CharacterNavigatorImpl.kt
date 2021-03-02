package com.example.akademiaandroida.features.character.navigation

import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import com.example.akademiaandroida.features.character.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_character_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }

}