package com.noke.zendevchallenge.data

import com.noke.zendevchallenge.data.model.PostApiModel
import com.noke.zendevchallenge.domain.model.Post

fun PostApiModel.toDomain(): Post {
    return Post(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}

fun List<PostApiModel>.toDomain(): List<Post> {
    return map { it.toDomain() }
}