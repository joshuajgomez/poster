package com.joshgm3z.poster.repository

data class Post(
    val id: String,
    val creator: User,
    val title: String?,
    val body: String?,
    val dateCreated: Long,
    val likesCount: Int,
    val dislikesCount: Int,
)

data class User(
    val id: String,
    val name: String,
    val followersCount: Int,
)
