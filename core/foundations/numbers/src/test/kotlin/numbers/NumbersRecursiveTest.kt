package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersRecursiveTest : StringSpec({

    "sumOfFirstNRec(0) returns 0" {
        Numbers.sumOfFirstNRec(0) shouldBe 0
    }

    "sumOfFirstNRec(3) returns 6" {
        Numbers.sumOfFirstNRec(3) shouldBe 6
    }

    "factorialRec(0) returns 1" {
        Numbers.factorialRec(0) shouldBe 1
    }

    "factorialRec(4) returns 24" {
        Numbers.factorialRec(4) shouldBe 24
    }

    "fibonacciRec(0) returns 0" {
        Numbers.fibonacciRec(0) shouldBe 0
    }

    "fibonacciRec(1) returns 1" {
        Numbers.fibonacciRec(1) shouldBe 1
    }

    "fibonacciRec(6) returns 8" {
        Numbers.fibonacciRec(6) shouldBe 8
    }

    "greatestCommonDivisorRec(12, 8) returns 4" {
        Numbers.greatestCommonDivisorRec(12, 8) shouldBe 4
    }

    "greatestCommonDivisorRec(7, 5) returns 1" {
        Numbers.greatestCommonDivisorRec(7, 5) shouldBe 1
    }

    "leastCommonMultipleRec(4, 6) returns 12" {
        Numbers.leastCommonMultipleRec(4, 6) shouldBe 12
    }

    "leastCommonMultipleRec(6, 8) returns 24" {
        Numbers.leastCommonMultipleRec(6, 8) shouldBe 24
    }
})
