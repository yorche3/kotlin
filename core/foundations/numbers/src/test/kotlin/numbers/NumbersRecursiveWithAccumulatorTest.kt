package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersRecursiveWithAccumulatorTest : StringSpec({

    "sumOfFirstNAcc(0) returns 0" {
        Numbers.sumOfFirstNAcc(0) shouldBe 0
    }

    "sumOfFirstNAcc(3) returns 6" {
        Numbers.sumOfFirstNAcc(3) shouldBe 6
    }

    "factorialAcc(0) returns 1" {
        Numbers.factorialAcc(0) shouldBe 1
    }

    "factorialAcc(4) returns 24" {
        Numbers.factorialAcc(4) shouldBe 24
    }

    "fibonacciAcc(0) returns 0" {
        Numbers.fibonacciAcc(0) shouldBe 0
    }

    "fibonacciAcc(1) returns 1" {
        Numbers.fibonacciAcc(1) shouldBe 1
    }

    "fibonacciAcc(6) returns 8" {
        Numbers.fibonacciAcc(6) shouldBe 8
    }

    "greatestCommonDivisorAcc(12, 8) returns 4" {
        Numbers.greatestCommonDivisorAcc(12, 8) shouldBe 4
    }

    "greatestCommonDivisorAcc(7, 5) returns 1" {
        Numbers.greatestCommonDivisorAcc(7, 5) shouldBe 1
    }

    "leastCommonMultipleAcc(4, 6) returns 12" {
        Numbers.leastCommonMultipleAcc(4, 6) shouldBe 12
    }

    "leastCommonMultipleAcc(6, 8) returns 24" {
        Numbers.leastCommonMultipleAcc(6, 8) shouldBe 24
    }
})
