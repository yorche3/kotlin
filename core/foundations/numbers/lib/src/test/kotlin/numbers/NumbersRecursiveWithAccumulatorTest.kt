package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersRecursiveWithAccumulatorTest : StringSpec({

    "sumOfFirstNAcc" {
        Numbers.sumOfFirstNAcc(0) shouldBe 0
        Numbers.sumOfFirstNAcc(3) shouldBe 6
    }

    "factorialAcc" {
        Numbers.factorialAcc(0) shouldBe 1
        Numbers.factorialAcc(4) shouldBe 24
    }

    "fibonacciAcc" {
        Numbers.fibonacciAcc(0) shouldBe 0
        Numbers.fibonacciAcc(1) shouldBe 1
        Numbers.fibonacciAcc(6) shouldBe 8
    }

    "greatestCommonDivisorAcc" {
        Numbers.greatestCommonDivisorAcc(12, 8) shouldBe 4
        Numbers.greatestCommonDivisorAcc(7, 5) shouldBe 1
    }

    "leastCommonMultipleAcc" {
        Numbers.leastCommonMultipleAcc(4, 6) shouldBe 12
        Numbers.leastCommonMultipleAcc(6, 8) shouldBe 24
    }
})
