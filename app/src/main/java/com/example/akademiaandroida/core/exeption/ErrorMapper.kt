package com.example.akademiaandroida.core.exeption

interface ErrorMapper {
    fun map(throwable: Throwable): String
}