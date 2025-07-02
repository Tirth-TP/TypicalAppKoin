package com.example.typicalappkoin.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializable

@InternalSerializationApi @Serializable
data class PostItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)