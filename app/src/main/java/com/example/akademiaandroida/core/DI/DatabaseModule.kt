package com.example.akademiaandroida.core.DI

import androidx.room.Room
import com.example.akademiaandroida.features.data.DatabaseHelper
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
}