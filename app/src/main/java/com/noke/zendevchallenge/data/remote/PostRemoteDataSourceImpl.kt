package com.noke.zendevchallenge.data.remote

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.data.model.PostApiModel
import javax.inject.Inject

class PostRemoteDataSourceImpl @Inject constructor(
    private val apiService: PostApiService
) : PostRemoteDataSource {

    override suspend fun getPosts(): Result<List<PostApiModel>> {
        return try {
            val result = apiService.getPosts()
            Result.Success(result)
        }catch (e: Exception){
            Result.Error(e)
        }
    }
}