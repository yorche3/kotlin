package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersIterativeTest : StringSpec({

    "sumOfFirstNIte(0) returns 0" {
        Numbers.sumOfFirstNIte(0) shouldBe 0
    }

    "sumOfFirstNIte(3) returns 6" {
        Numbers.sumOfFirstNIte(3) shouldBe 6
    }

    "factorialIte(0) returns 1" {
        Numbers.factorialIte(0) shouldBe 1
    }

    "factorialIte(4) returns 24" {
        Numbers.factorialIte(4) shouldBe 24
    }

    "fibonacciIte(0) returns 0" {
        Numbers.fibonacciIte(0) shouldBe 0
    }

    "fibonacciIte(1) returns 1" {
        Numbers.fibonacciIte(1) shouldBe 1
    }

    "fibonacciIte(6) returns 8" {
        Numbers.fibonacciIte(6) shouldBe 8
    }

    "greatestCommonDivisorIte(12, 8) returns 4" {
        Numbers.greatestCommonDivisorIte(12, 8) shouldBe 4
    }

    "greatestCommonDivisorIte(7, 5) returns 1" {
        Numbers.greatestCommonDivisorIte(7, 5) shouldBe 1
    }

    "leastCommonMultipleIte(4, 6) returns 12" {
        Numbers.leastCommonMultipleIte(4, 6) shouldBe 12
    }

    "leastCommonMultipleIte(6, 8) returns 24" {
        Numbers.leastCommonMultipleIte(6, 8) shouldBe 24
    }
})
