package calculator

class Calculator {
    fun addition(a: Int, b: Int): Int = a + b

    fun subtraction(a: Int, b: Int): Int = a - b

    fun multiplication(a: Int, b: Int): Int {
        var result = 0
        repeat(b) {
            result = addition(result, a)
        }
        return result
    }

    fun division(a: Int, b: Int): Int {
        var remaining = a
        var count = 0
        while (remaining >= b) {
            remaining = subtraction(remaining, b)
            count = addition(count, 1)
        }
        return count
    }

    fun modulus(a: Int, b: Int): Int {
        val q = division(a, b)
        val p = multiplication(q, b)
        return subtraction(a, p)
    }
}
