package com.example.akademiaandroida.features.episodes.presentation.model


data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {

    constructor(episodeDisplayable: EpisodeDisplayable) : this(
        id = episodeDisplayable.id,
        name = episodeDisplayable.name,
        airDate = episodeDisplayable.airDate,
        code = episodeDisplayable.code,
        characters = episodeDisplayable.characters,
        url = episodeDisplayable.url
    )
}