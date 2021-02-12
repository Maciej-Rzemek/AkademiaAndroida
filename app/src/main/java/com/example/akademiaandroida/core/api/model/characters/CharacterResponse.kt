package com.example.akademiaandroida.core.api.model.characters

import com.example.akademiaandroida.core.api.model.ResponseInfo
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}