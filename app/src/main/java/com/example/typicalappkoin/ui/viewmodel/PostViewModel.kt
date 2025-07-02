package com.example.typicalappkoin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.typicalappkoin.data.model.PostResponseItem
import com.example.typicalappkoin.data.remote.PostRepository
import kotlinx.coroutines.launch

/**
 * Created by Tirth Patel.
 */


class PostViewModel(
    private val repository: PostRepository
) : ViewModel(){
    private val _posts = MutableLiveData<List<PostResponseItem>>()
    val posts: LiveData<List<PostResponseItem>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }
}
