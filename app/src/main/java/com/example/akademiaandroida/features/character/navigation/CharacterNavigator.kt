package com.example.akademiaandroida.features.character.navigation

import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()

}