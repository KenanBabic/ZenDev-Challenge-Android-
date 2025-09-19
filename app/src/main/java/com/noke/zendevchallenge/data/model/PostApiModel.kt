package com.noke.zendevchallenge.data.model

import com.google.gson.annotations.SerializedName

data class PostApiModel(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)