package com.example.akademiaandroida.features.character.all.presentation.model

import android.os.Parcelable
import com.example.akademiaandroida.features.character.domain.model.CharacterLocation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )

    companion object
}