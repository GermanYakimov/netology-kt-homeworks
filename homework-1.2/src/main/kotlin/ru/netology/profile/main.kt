package ru.netology.profile

import ru.netology.profile.model.Profile

fun main() {
    val profile = Profile(1, "something", "Ivan", "Ivanov", "Hello", "")

    println(profile.id)
    println(profile.login)
    println(profile.name)
    println(profile.surname)
    println(profile.status)
    println(profile.fullname)
}
