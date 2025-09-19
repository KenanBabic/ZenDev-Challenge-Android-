package com.noke.zendevchallenge.data.remote

import com.noke.zendevchallenge.data.model.PostApiModel
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    suspend fun getPosts(): List<PostApiModel>
}