package ru.netology.social.model

class Post {
    val id: Int = 0
    lateinit var text: String
    val date: Int = 0
    val ownerId: Int = 0
    var comments = object {}
    var likes = object {}
    var reposts = object {}
    var views: Int = 0
    var geo = null
    var isPinned: Boolean = false
    var createdBy: Int = 0
}