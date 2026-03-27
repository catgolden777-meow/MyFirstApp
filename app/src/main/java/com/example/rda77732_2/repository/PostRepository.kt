package com.example.rda77732_2.repository

import androidx.lifecycle.LiveData
import com.example.rda77732_2.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun shareById(id: Long)
    fun increaseViews(id: Long)
    fun save(post: Post): Post
    fun removeById(id: Long)
}

