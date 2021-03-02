package com.example.akademiaandroida.features.character.all.presentation.model

import android.os.Parcelable
import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterOriginDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )

    companion object
}
