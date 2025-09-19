package com.noke.zendevchallenge.domain

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.domain.model.Post

class FakePostRepository : PostRepository {
    private var result: Result<List<Post>> = Result.Success(emptyList())

    fun setResult(result: Result<List<Post>>) {
        this.result = result
    }

    override suspend fun getPosts(): Result<List<Post>> {
        return result
    }
}