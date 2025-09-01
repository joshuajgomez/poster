package com.joshgm3z.poster.repository.firebase;

import com.google.firebase.Firebase
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.Filter
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.firestore
import com.joshgm3z.poster.repository.Post
import com.joshgm3z.poster.utils.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreDb
@Inject
constructor(
    private val firebaseLogger: FirebaseLogger
) {
    private val firestore = Firebase.firestore

    private val keyCollectionChatList = "chats_list"
    private val keyCollectionUserList = "users_list"

    private lateinit var listenerRegistration: ListenerRegistration

    fun createChatDocId(): String =
        firestore.collection(keyCollectionChatList).document().id

    fun submitPost(
        post: Post,
        onIdSet: (id: String) -> Unit,
        onError: () -> Unit,
    ) {
        Logger.debug("post = [${post}]")
       /* val chatDoc = FirestoreConverter.getDocumentFromChat(chat)
        firestore.collection(keyCollectionChatList)
            .add(chatDoc)
            .addOnSuccessListener {
                Logger.debug("chat <${chat}> added with id: ${it.id}")
                onIdSet(it.id)
            }
            .addOnFailureListener {
                Logger.warn("error adding chat: ${it.message}")
                onError()
            }*/
    }
}