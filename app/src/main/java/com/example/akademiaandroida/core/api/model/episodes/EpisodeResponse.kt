package com.example.akademiaandroida.core.api.model.episodes

import com.example.akademiaandroida.core.api.model.ResponseInfo
import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}