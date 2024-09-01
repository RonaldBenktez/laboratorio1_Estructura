interface NumberType {
    val type: String
    fun isValid(): Boolean
}
class PrimeNumber(val value: Int) : NumberType {
    override val type: String = "Prime"
    
    override fun isValid(): Boolean {
        if (value < 2) return false
        for (i in 2 until value) {
            if (value % i == 0) return false
        }
        return true
    }
}

class EvenNumber(val value: Int) : NumberType {
    override val type: String = "Even"
    
    override fun isValid(): Boolean {
        return value % 2 == 0
    }
}

class OddNumber(val value: Int) : NumberType {
    override val type: String = "Odd"
    
    override fun isValid(): Boolean {
        return value % 2 != 0
    }
}

class NumberCounter(val n: Int) {
    private val primes = mutableListOf<Int>()
    private val evens = mutableListOf<Int>()
    private val odds = mutableListOf<Int>()

    init {
        if (n <= 0) {
            throw IllegalArgumentException("N must be greater than 0")
        }
        countNumbers()
    }

    private fun countNumbers() {
        for (i in 1..n) {
            val prime = PrimeNumber(i)
            val even = EvenNumber(i)
            val odd = OddNumber(i)
            
            if (prime.isValid()) primes.add(i)
            if (even.isValid()) evens.add(i)
            if (odd.isValid()) odds.add(i)
        }
    }

    fun getPrimeCount(): Int = primes.size
    fun getEvenCount(): Int = evens.size
    fun getOddCount(): Int = odds.size
}

fun main() {
    try {
        val numberCounter = NumberCounter(10)
        println("Prime numbers count: ${numberCounter.getPrimeCount()}")
        println("Even numbers count: ${numberCounter.getEvenCount()}")
        println("Odd numbers count: ${numberCounter.getOddCount()}")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
