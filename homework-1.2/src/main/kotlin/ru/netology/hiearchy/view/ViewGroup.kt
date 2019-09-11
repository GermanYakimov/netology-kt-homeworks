package ru.netology.hiearchy.view

class ViewGroup: View() {
    var views: MutableList<View> = mutableListOf()

    fun addView(view: View) {
        views.add(view)
    }
}