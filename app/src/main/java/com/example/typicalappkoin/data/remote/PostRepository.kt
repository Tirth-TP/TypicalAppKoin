package com.example.typicalappkoin.data.remote

import com.example.typicalappkoin.data.model.PostResponseItem

/**
 * Created by Tirth Patel.
 */
interface PostRepository {
    suspend fun getPosts(): List<PostResponseItem>
}