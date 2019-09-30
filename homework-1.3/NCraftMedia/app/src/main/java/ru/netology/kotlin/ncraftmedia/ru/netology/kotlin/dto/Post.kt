package ru.netology.kotlin.ncraftmedia.ru.netology.kotlin.dto

class Post (
    val id: Long,
    var author: String,
    val content: String,
    val created: String,
    var likesCount: Int = 0,
    var commentsCount: Int = 0,
    var sharesCount: Int = 0,
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false
)
