package com.example.akademiaandroida.core.DI

import org.koin.core.module.Module

var koinInjector: List<Module> = listOf(
    networkModule
)