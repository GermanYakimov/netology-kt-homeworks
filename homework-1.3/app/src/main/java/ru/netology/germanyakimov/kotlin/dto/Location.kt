package ru.netology.germanyakimov.kotlin.dto

class Location(val lat:Double, val lon:Double) {
    operator fun plus(other:Location) = Location(lat+other.lat,lon+other.lon)
    operator fun component1() = lat
    operator fun component2() = lon
}

infix fun Double.x(that:Double)=Location(this,that)
