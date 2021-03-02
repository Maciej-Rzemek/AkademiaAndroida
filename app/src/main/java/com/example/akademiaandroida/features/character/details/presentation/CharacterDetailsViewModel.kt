package com.example.akademiaandroida.features.character.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.akademiaandroida.core.base.BaseViewModel
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable

class CharacterDetailsViewModel : BaseViewModel() {

    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun onCharacterDataPassed(characterDisplayable: CharacterDisplayable) {
        _character.value = characterDisplayable
    }

}
