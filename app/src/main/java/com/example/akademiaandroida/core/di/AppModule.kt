package com.example.akademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.akademiaandroida.R
import com.example.akademiaandroida.core.exeption.ErrorMapper
import com.example.akademiaandroida.core.exeption.ErrorMapperImpl
import com.example.akademiaandroida.core.exeption.ErrorWrapper
import com.example.akademiaandroida.core.exeption.ErrorWrapperImpl
import com.example.akademiaandroida.core.navigation.FragmentNavigator
import com.example.akademiaandroida.core.navigation.FragmentNavigatorImpl
import com.example.akademiaandroida.core.network.NetworkStateProvider
import com.example.akademiaandroida.core.network.NetworkStateProviderImpl
import com.example.akademiaandroida.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { GridLayoutManager(androidContext(), 2) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }

    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}