package com.noke.zendevchallenge.domain

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.domain.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
}