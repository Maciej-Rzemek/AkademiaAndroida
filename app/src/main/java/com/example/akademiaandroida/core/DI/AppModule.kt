package com.example.akademiaandroida.core.DI

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single { LinearLayoutManager(get()) }

    single { GridLayoutManager(get(), 2) }

    single { DividerItemDecoration(get(), LinearLayoutManager.VERTICAL) }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}