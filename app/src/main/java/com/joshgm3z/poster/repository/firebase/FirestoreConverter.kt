package com.joshgm3z.poster.repository.firebase;

import com.google.firebase.firestore.QuerySnapshot
import com.joshgm3z.poster.repository.Post
import com.joshgm3z.poster.repository.User
import com.joshgm3z.poster.utils.Logger

class FirestoreConverter {
    companion object {

        fun getDocumentFromPost(post: Post): HashMap<String, Any> {
            return hashMapOf(
                FirestoreKey.Post.title to post.title.toString(),
                FirestoreKey.Post.body to post.body.toString(),
                FirestoreKey.Post.creator to post.creator.toString(),
                FirestoreKey.Post.dateCreated to post.dateCreated.toString(),
                FirestoreKey.Post.likesCount to post.likesCount.toString(),
                FirestoreKey.Post.dislikesCount to post.dislikesCount.toString(),
            )
        }

        fun getPostFromDocument(post: Post): HashMap<String, Any> {
            return hashMapOf(
                FirestoreKey.Post.title to post.title.toString(),
                FirestoreKey.Post.body to post.body.toString(),
                FirestoreKey.Post.creator to post.creator.toString(),
                FirestoreKey.Post.dateCreated to post.dateCreated.toString(),
                FirestoreKey.Post.likesCount to post.likesCount.toString(),
                FirestoreKey.Post.dislikesCount to post.dislikesCount.toString(),
            )
        }

        fun getPostListFromDocument(result: QuerySnapshot): ArrayList<Post> {
            val postList = ArrayList<Post>()
            result.forEach {
                with(it) {
                    try {
                        postList.add(
                            Post(
                                id = id,
                                title = get(FirestoreKey.Post.title).toString(),
                                body = get(FirestoreKey.Post.body).toString(),
                                creator = User(get(FirestoreKey.Post.creator).toString(), "", 1),
                                dateCreated = get(FirestoreKey.Post.dateCreated) as Long,
                                likesCount = get(FirestoreKey.Post.likesCount).toInt(),
                                dislikesCount = get(FirestoreKey.Post.dislikesCount).toInt(),
                            )
                        )
                    } catch (e: Exception) {
                        Logger.debug(e.stackTraceToString())
                    }
                }
            }
            return postList
        }

    }
}

private fun Any?.toInt(): Int = when {
    this == null -> 0
    else -> Integer.parseInt(this.toString())
}


