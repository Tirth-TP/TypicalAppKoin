package com.example.typicalappkoin.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)