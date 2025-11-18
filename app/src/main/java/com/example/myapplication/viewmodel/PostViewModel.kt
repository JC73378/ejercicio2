package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Post
import com.example.myapplication.data.repository.PostRepository
import kotlin.coroutines.flow.MutableStateFlow
import kotlin.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewMode: ViewModel() {
    private val repository = PostRepository()
    private val _postslist = MutableStateFlow<List<Post>>(emptyList())

    val postslist: StateFlow<List<Post>> = _postslist

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _postslist.value = repository.getPosts()
            } catch (e: Exception) {
                print("error al obtener los datos: ${e.localizedMessage}")
            }

        }
    }


}