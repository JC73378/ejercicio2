package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Post
import com.example.myapplication.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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
                _postslist.value = repository.getPost()
            } catch (e: Exception) {
                print("error al obtener los datos: ${e.localizedMessage}")
            }

        }
    }


}