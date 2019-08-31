fun main() {
    println(massIndexVerdict(bodyMassIndex(50.0, 1.8)))
    println(massIndexVerdict(bodyMassIndex(70.0, 1.8)))
    println(massIndexVerdict(bodyMassIndex(100.0, 1.7)))
}

fun massIndexVerdict(index: Double): String = when {
    (index <= 16) -> "pronounced deficit of body mass"
    (index > 16 && index <= 18.5) -> "deficit of body mass"
    (index > 18.5 && index <= 25) -> "normal"
    (index > 25 && index <= 30) -> "excess body mass"
    (index > 30 && index <= 35) -> "obesity"
    (index > 35 && index <= 40) -> "severe obesity"
    else -> "very severe obesity"
}


fun bodyMassIndex(mass: Double, height: Double): Double =  mass / (height * height)

