package ru.netology.hiearchy

import ru.netology.hiearchy.view.ViewGroup
import ru.netology.hiearchy.widget.Button
import ru.netology.hiearchy.widget.TextView

fun main() {
    val main = ViewGroup()
    val title = TextView("Main Screen")
    println(title.text)
    main.addView(title)

    val content = ViewGroup()
    val readMore = Button("Read more")
    println(readMore.text)
    content.addView(readMore)
}