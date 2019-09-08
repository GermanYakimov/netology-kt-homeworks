package ru.netology.profile.model

class Profile (val id: Int,
               val login: String,
               var name: String,
               var surname: String,
               var status: String,
               var avatar: String) {

    var fullname: String = "$name $surname"
}
