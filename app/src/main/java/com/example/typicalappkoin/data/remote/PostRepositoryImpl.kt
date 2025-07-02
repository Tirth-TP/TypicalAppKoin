package com.example.typicalappkoin.data.remote

import com.example.typicalappkoin.data.model.PostResponseItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * Created by Tirth Patel.
 */
class PostRepositoryImpl(val client: HttpClient) : PostRepository{

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val GET_ALBUMS_ENDPOINT = "post"

    override suspend fun getPosts(): List<PostResponseItem> {
        return try {
            client.get("/posts").body()
        } catch (e: Exception) {
            emptyList()
        }
    }
}