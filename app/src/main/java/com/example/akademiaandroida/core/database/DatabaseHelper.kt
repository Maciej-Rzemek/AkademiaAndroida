package com.example.akademiaandroida.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.akademiaandroida.features.character.data.local.CharactersDao
import com.example.akademiaandroida.features.character.data.local.model.CharacterCached
import com.example.akademiaandroida.features.episodes.data.local.EpisodeDao
import com.example.akademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.example.akademiaandroida.features.location.data.local.LocationsDao
import com.example.akademiaandroida.features.location.data.local.model.LocationsCached

@Database(
    entities = [EpisodeCached::class, LocationsCached::class, CharacterCached::class],
    version = 1
)

@TypeConverters(ListConverter::class)
abstract class DatabaseHelper : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun locationsDao(): LocationsDao
    abstract fun charactersDao(): CharactersDao
}