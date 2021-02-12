package com.example.akademiaandroida.core.DI

import androidx.room.Room
import com.example.akademiaandroida.core.database.DatabaseHelper
import com.example.akademiaandroida.utils.DATABASE_NAME
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get(),
            DatabaseHelper::class.java,
            DATABASE_NAME
        )
            .build()
    }

    single { get<DatabaseHelper>().episodeDao() }
    single { get<DatabaseHelper>().locationsDao() }
    single { get<DatabaseHelper>().charactersDao() }
}