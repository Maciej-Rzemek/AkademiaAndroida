package com.example.akademiaandroida.features.location

import com.example.akademiaandroida.features.location.domain.model.Location

interface LocationsRepository {
    suspend fun getLocations(): List<Location>
}