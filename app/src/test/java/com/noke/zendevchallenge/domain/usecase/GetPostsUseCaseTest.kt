package com.noke.zendevchallenge.domain.usecase

import com.noke.zendevchallenge.data.Result
import com.noke.zendevchallenge.domain.FakePostRepository
import com.noke.zendevchallenge.domain.model.Post
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPostsUseCaseTest {

    private lateinit var fakePostRepository: FakePostRepository
    private lateinit var getPostsUseCase: GetPostsUseCase

    @Before
    fun setUp() {
        fakePostRepository = FakePostRepository()
        getPostsUseCase = GetPostsUseCase(fakePostRepository)
    }

    @Test
    fun `invoke should return empty list when repository returns success but all posts have id greater than or equal to 50`() {
        runBlocking {
            // Given
            val allPosts = listOf(
                Post(userId = 1, id = 50, title = "Post 50", body = "Body 50"),
                Post(userId = 2, id = 75, title = "Post 75", body = "Body 75"),
                Post(userId = 3, id = 100, title = "Post 100", body = "Body 100")
            )
            fakePostRepository.setResult(Result.Success(allPosts))

            // When
            val result = getPostsUseCase()

            // Then
            val successResult = result as Result.Success
            assertTrue("Returned list should be empty", successResult.data.isEmpty())
        }
    }

    @Test
    fun `invoke should return all posts when repository returns success and all posts have id less than 50`() {
        runBlocking {
            // Given
            val allValidPosts = listOf(
                Post(userId = 1, id = 1, title = "Post 1", body = "Body 1"),
                Post(userId = 1, id = 10, title = "Post 10", body = "Body 10"),
                Post(userId = 2, id = 25, title = "Post 25", body = "Body 25"),
                Post(userId = 2, id = 49, title = "Post 49", body = "Body 49")
            )
            fakePostRepository.setResult(Result.Success(allValidPosts))

            // When
            val result = getPostsUseCase()

            // Then
            val successResult = result as Result.Success
            assertEquals("Should return original posts", allValidPosts, successResult.data)
        }
    }

}