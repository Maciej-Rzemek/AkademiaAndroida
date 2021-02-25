package com.example.akademiaandroida.features.character.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.akademiaandroida.core.base.BaseViewModel
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.features.character.domain.GetCharactersUseCase
import com.example.akademiaandroida.features.character.domain.model.Character
import com.example.akademiaandroida.features.character.presentation.model.CharacterDisplayable

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(charactersLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { charactersLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}