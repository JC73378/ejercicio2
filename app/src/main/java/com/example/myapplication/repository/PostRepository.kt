package com.example.myapplication.repository

import com.example.myapplication.data.model.Post
import com.example.myapplication.data.remote.RetrofitInstance

class PostRepository {

    suspend fun getPost(): List<Post>{
        return RetrofitInstance.api.getPosts()
    }
}