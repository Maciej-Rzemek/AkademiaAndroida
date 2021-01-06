package com.example.akademiaandroida.core.DI

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.dsl.module

val appModule = module {

    single { LinearLayoutManager(get()) }

    single { GridLayoutManager(get(), 2) }

    single { DividerItemDecoration(get(), LinearLayoutManager.VERTICAL) }
}