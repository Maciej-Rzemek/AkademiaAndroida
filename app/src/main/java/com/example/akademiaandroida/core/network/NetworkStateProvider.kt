package com.example.akademiaandroida.core.network

interface NetworkStateProvider {

    fun isNetworkAvailable(): Boolean

}