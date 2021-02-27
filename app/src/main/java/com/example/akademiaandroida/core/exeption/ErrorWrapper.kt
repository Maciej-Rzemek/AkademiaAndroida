package com.example.akademiaandroida.core.exeption

interface ErrorWrapper {

    fun wrap(throwable: Throwable): Throwable
}