package com.noke.zendevchallenge.domain.usecase

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.domain.PostRepository
import com.noke.zendevchallenge.domain.model.Post
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(): Result<List<Post>> {
        return when (val result = postRepository.getPosts()) {
            is Result.Success -> {
                val filteredPosts = result.data.filter { it.id < 50 }
                Result.Success(filteredPosts)
            }

            is Result.Error -> {
                result
            }
        }
    }
}