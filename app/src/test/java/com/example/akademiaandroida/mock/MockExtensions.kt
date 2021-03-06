package com.example.akademiaandroida.mock

import com.example.akademiaandroida.core.api.model.ResponseInfo
import com.example.akademiaandroida.core.api.model.characters.CharacterLocationRemote
import com.example.akademiaandroida.core.api.model.characters.CharacterOriginRemote
import com.example.akademiaandroida.core.api.model.characters.CharacterRemote
import com.example.akademiaandroida.core.api.model.characters.CharacterResponse
import com.example.akademiaandroida.core.api.model.episodes.EpisodeRemote
import com.example.akademiaandroida.core.api.model.episodes.EpisodeResponse
import com.example.akademiaandroida.core.api.model.locations.LocationsRemote
import com.example.akademiaandroida.core.api.model.locations.LocationsResponse
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterDisplayable
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterLocationDisplayable
import com.example.akademiaandroida.features.character.all.presentation.model.CharacterOriginDisplayable
import com.example.akademiaandroida.features.character.data.local.model.CharacterCached
import com.example.akademiaandroida.features.character.data.local.model.CharacterLocationCached
import com.example.akademiaandroida.features.character.data.local.model.CharacterOriginCached
import com.example.akademiaandroida.features.character.domain.model.Character
import com.example.akademiaandroida.features.character.domain.model.CharacterLocation
import com.example.akademiaandroida.features.character.domain.model.CharacterOrigin
import com.example.akademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.example.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.akademiaandroida.features.episodes.domain.model.Episode
import com.example.akademiaandroida.features.location.all.presentation.model.LocationDisplayable
import com.example.akademiaandroida.features.location.data.local.model.LocationsCached
import com.example.akademiaandroida.features.location.domain.model.Location
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "prev page url"
)

// Episodes

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url",
    created = "created"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)


@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)

// Locations

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationsRemote.mock(),
        LocationsRemote.mock(),
        LocationsRemote.mock()
    )
)

@TestOnly
fun LocationsRemote.Companion.mock() = LocationsRemote(
    id = 1,
    name = "name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url",
    created = "created"
)

@TestOnly
fun LocationDisplayable.Companion.mock() = LocationDisplayable(
    id = 1,
    name = "name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)


@TestOnly
fun LocationsCached.Companion.mock() = LocationsCached(
    id = 1,
    name = "name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)

// Characters

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "name",
    status = "status",
    species = "species",
    type = "type",
    gender = "gender",
    characterOriginRemote = CharacterOriginRemote.mock(),
    characterLocationRemote = CharacterLocationRemote.mock(),
    image = "image",
    episode = emptyList(),
    url = "url",
    created = "created"
)


@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "name",
    status = "status",
    species = "species",
    type = "type",
    gender = "gender",
    characterOriginCached = CharacterOriginCached.mock(),
    characterLocationCached = CharacterLocationCached.mock(),
    image = "image",
    episode = emptyList(),
    url = "url",
    created = "created"
)

@TestOnly
fun CharacterDisplayable.Companion.mock() = CharacterDisplayable(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character species",
    gender = "character gender",
    characterOrigin = CharacterOriginDisplayable.mock(),
    characterLocation = CharacterLocationDisplayable.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url",
    created = "character type"
)

@TestOnly
fun CharacterLocationDisplayable.Companion.mock() = CharacterLocationDisplayable(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterOriginDisplayable.Companion.mock() = CharacterOriginDisplayable(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterOriginRemote.Companion.mock() = CharacterOriginRemote(
    name = "name",
    url = "url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    locationName = "name",
    locationUrl = "url"
)

@TestOnly
fun CharacterOriginCached.Companion.mock() = CharacterOriginCached(
    originName = "name",
    originUrl = "url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "name",
    airDate = "airDate",
    code = "code",
    characters = emptyList(),
    url = "url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    name = "name",
    type = "type",
    dimension = "dimension",
    residents = emptyList(),
    url = "url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    name = "name",
    status = "status",
    species = "species",
    type = "type",
    gender = "gender",
    characterOrigin = CharacterOrigin.mock(),
    characterLocation = CharacterLocation.mock(),
    image = "image",
    episode = emptyList(),
    url = "url",
    created = "created"
)

@TestOnly
fun CharacterOrigin.Companion.mock() = CharacterOrigin(
    name = "character name",
    url = "character url"
)

@TestOnly
fun CharacterLocation.Companion.mock() = CharacterLocation(
    name = "character name",
    url = "character url"
)




