package ru.netology.kotlin.ncraftmedia.ru.netology.kotlin.dto

class Post (
    val id: Long,
    val author: String,
    val content: String,
    val created: String,
    var likedByMe: Boolean = false
)
