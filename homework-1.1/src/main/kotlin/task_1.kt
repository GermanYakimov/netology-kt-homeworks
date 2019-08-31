fun main() {
    println(calculateFee(amount = 200, total = 11_000))
    println(calculateFee(amount = 500, total = 800, exclusive = true))
    println(calculateFee(amount = 300, total = 60_000))
}

fun calculateFee(amount: Int, total: Int, exclusive: Boolean = false): Double {
    val percent: Double = (if (exclusive) -0.05 else 0.0) + when {
        (total in 0..1000) -> 0.3
        (total in 1001..10_000) -> 0.25
        (total in 10_001..50_000) -> 0.2
        else -> 0.15
    }

    return amount * percent
}