package com.example.akademiaandroida.core.di

import androidx.room.Room
import com.example.akademiaandroida.core.database.DatabaseHelper
import com.example.akademiaandroida.utils.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            DatabaseHelper::class.java,
            DATABASE_NAME
        ).build()
    }

    single { get<DatabaseHelper>().episodeDao() }
    single { get<DatabaseHelper>().locationsDao() }
    single { get<DatabaseHelper>().charactersDao() }
}