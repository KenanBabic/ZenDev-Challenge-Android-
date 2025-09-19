package com.noke.zendevchallenge.data.repository

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.data.remote.PostRemoteDataSource
import com.noke.zendevchallenge.data.toDomain
import com.noke.zendevchallenge.domain.PostRepository
import com.noke.zendevchallenge.domain.model.Post
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val remoteDataSource: PostRemoteDataSource
) : PostRepository {

    override suspend fun getPosts(): Result<List<Post>> {
        return when (val result = remoteDataSource.getPosts()) {
            is Result.Success -> {
                Result.Success(result.data.toDomain())
            }
            is Result.Error -> {
                result
            }
        }
    }
}