package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersRecursiveTest : StringSpec({

    "sumOfFirstNRec" {
        Numbers.sumOfFirstNRec(0) shouldBe 0
        Numbers.sumOfFirstNRec(3) shouldBe 6
    }

    "factorialRec" {
        Numbers.factorialRec(0) shouldBe 1
        Numbers.factorialRec(4) shouldBe 24
    }

    "fibonacciRec" {
        Numbers.fibonacciRec(0) shouldBe 0
        Numbers.fibonacciRec(1) shouldBe 1
        Numbers.fibonacciRec(6) shouldBe 8
    }

    "greatestCommonDivisorRec" {
        Numbers.greatestCommonDivisorRec(12, 8) shouldBe 4
        Numbers.greatestCommonDivisorRec(7, 5) shouldBe 1
    }

    "leastCommonMultipleRec" {
        Numbers.leastCommonMultipleRec(4, 6) shouldBe 12
        Numbers.leastCommonMultipleRec(6, 8) shouldBe 24
    }
})
