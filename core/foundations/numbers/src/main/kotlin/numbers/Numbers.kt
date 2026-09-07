package numbers

object Numbers {

    // ---- Direct recursion (_rec) ----

    fun sumOfFirstNRec(n: Int): Int {
        if (n <= 0) {
            return 0
        }
        return n + sumOfFirstNRec(n - 1)
    }

    fun factorialRec(n: Int): Int {
        if (n <= 0) {
            return 1
        }
        return n * factorialRec(n - 1)
    }

    fun fibonacciRec(n: Int): Int {
        if (n <= 1) {
            return n
        }
        return fibonacciRec(n - 1) + fibonacciRec(n - 2)
    }

    fun greatestCommonDivisorRec(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return greatestCommonDivisorRec(b, a % b)
    }

    fun leastCommonMultipleRec(a: Int, b: Int): Int =
        (a * b) / greatestCommonDivisorRec(a, b)

    // ---- Accumulator recursion (_acc) ----

    fun sumOfFirstNAcc(n: Int): Int = sumOfFirstNAccHelp(n, 0)

    private tailrec fun sumOfFirstNAccHelp(n: Int, acc: Int): Int {
        if (n <= 0) {
            return acc
        }
        return sumOfFirstNAccHelp(n - 1, n + acc)
    }

    fun factorialAcc(n: Int): Int = factorialAccHelp(n, 1)

    private tailrec fun factorialAccHelp(n: Int, acc: Int): Int {
        if (n <= 1) {
            return acc
        }
        return factorialAccHelp(n - 1, n * acc)
    }

    fun fibonacciAcc(n: Int): Int = fibonacciAccHelp(n, 0, 1)

    private tailrec fun fibonacciAccHelp(n: Int, acc2: Int, acc1: Int): Int {
        if (n <= 0) {
            return acc2
        }
        if (n <= 2) {
            return acc1 + acc2
        }
        return fibonacciAccHelp(n - 1, acc1, acc1 + acc2)
    }

    fun greatestCommonDivisorAcc(a: Int, b: Int): Int =
        greatestCommonDivisorAccHelp(a, b)

    private tailrec fun greatestCommonDivisorAccHelp(a: Int, b: Int): Int {
        if (b == 0) {
            return a
        }
        return greatestCommonDivisorAccHelp(b, a % b)
    }

    fun leastCommonMultipleAcc(a: Int, b: Int): Int =
        (a * b) / greatestCommonDivisorAcc(a, b)

    // ---- Iterative (_ite) ----

    fun sumOfFirstNIte(n: Int): Int {
        var result = 0
        for (i in 1..n) {
            result += i
        }
        return result
    }

    fun factorialIte(n: Int): Int {
        var result = 1
        for (i in 2..n) {
            result *= i
        }
        return result
    }

    fun fibonacciIte(n: Int): Int {
        if (n <= 1) {
            return n
        }
        var acc2 = 0
        var acc1 = 1
        for (i in 2..n) {
            val temp = acc1 + acc2
            acc2 = acc1
            acc1 = temp
        }
        return acc1
    }

    fun greatestCommonDivisorIte(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }

    fun leastCommonMultipleIte(a: Int, b: Int): Int =
        (a * b) / greatestCommonDivisorIte(a, b)
}
