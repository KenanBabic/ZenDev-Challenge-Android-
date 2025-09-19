package com.noke.zendevchallenge.presentation.uistate

import com.noke.zendevchallenge.domain.model.Post

data class PostsUiState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val errorMessage: String? = null
)