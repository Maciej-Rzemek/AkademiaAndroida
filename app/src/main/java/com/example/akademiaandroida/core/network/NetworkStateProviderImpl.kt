package com.example.akademiaandroida.core.network

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

class NetworkStateProviderImpl(
    private val connectivityManager: ConnectivityManager
) : NetworkStateProvider {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun isNetworkAvailable(): Boolean {
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                ?: return false

        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    or capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    or capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}