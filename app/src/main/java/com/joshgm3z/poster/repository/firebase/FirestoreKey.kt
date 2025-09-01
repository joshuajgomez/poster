package com.joshgm3z.poster.repository.firebase

class FirestoreKey {
    class Post {
        companion object {
            val title: String = "title"
            val body: String = "body"
            val creator: String = "creator"
            val dateCreated: String = "dateCreated"
            val likesCount: String = "likesCount"
            val dislikesCount: String = "dislikesCount"
        }
    }
}
