package com.example.akademiaandroida.features.location.domain

import com.example.akademiaandroida.core.base.UseCase
import com.example.akademiaandroida.features.location.domain.model.Location

class GetLocationsUseCase(private val locationsRepository: LocationsRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit): List<Location> = locationsRepository.getLocations()


}