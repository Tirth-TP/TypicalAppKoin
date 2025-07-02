package com.example.typicalappkoin.di

import com.example.typicalappkoin.data.remote.KoinClient
import com.example.typicalappkoin.data.remote.PostRepository
import com.example.typicalappkoin.data.remote.PostRepositoryImpl
import com.example.typicalappkoin.ui.viewmodel.PostViewModel
import io.ktor.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Tirth Patel.
 */

val appModule = module {
    // Define your dependencies here

    single<HttpClient> { KoinClient.getClient() }
    single<PostRepository> { PostRepositoryImpl(get()) }

    // ViewModel using the repository
    viewModel { PostViewModel(get()) }

}