package com.example.akademiaandroida.features.character.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterOrigin(
    val name: String,
    val url: String
) : Parcelable {
    companion object
}