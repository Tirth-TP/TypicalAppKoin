package com.example.typicalappkoin.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Created by Tirth Patel.
 */
object KoinClient {

    fun getClient(): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }

                install(HttpTimeout) {
                    socketTimeoutMillis = 3000
                    requestTimeoutMillis = 3000
                    connectTimeoutMillis = 3000
                }

        defaultRequest {
            url("https://jsonplaceholder.typicode.com")
            //header(HttpHeaders.Authorization, "ljklfhsgfdfjdlskfjdslfjdjkls") // optional
        }

        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.BODY
        }
    }
}
