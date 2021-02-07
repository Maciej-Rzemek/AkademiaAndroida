package com.example.akademiaandroida.core.api.model.locations

import com.example.akademiaandroida.core.api.model.ResponseInfo
import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationsRemote>
) {
    companion object
}