package com.noke.zendevchallenge.data.remote

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.data.model.PostApiModel

interface PostRemoteDataSource {
    suspend fun getPosts(): Result<List<PostApiModel>>

}