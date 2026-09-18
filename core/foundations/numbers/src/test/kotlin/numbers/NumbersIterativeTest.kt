package numbers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersIterativeTest : StringSpec({

    "sumOfFirstNIte" {
        Numbers.sumOfFirstNIte(0) shouldBe 0
        Numbers.sumOfFirstNIte(3) shouldBe 6
    }

    "factorialIte" {
        Numbers.factorialIte(0) shouldBe 1
        Numbers.factorialIte(4) shouldBe 24
    }

    "fibonacciIte" {
        Numbers.fibonacciIte(0) shouldBe 0
        Numbers.fibonacciIte(1) shouldBe 1
        Numbers.fibonacciIte(6) shouldBe 8
    }

    "greatestCommonDivisorIte" {
        Numbers.greatestCommonDivisorIte(12, 8) shouldBe 4
        Numbers.greatestCommonDivisorIte(7, 5) shouldBe 1
    }

    "leastCommonMultipleIte" {
        Numbers.leastCommonMultipleIte(4, 6) shouldBe 12
        Numbers.leastCommonMultipleIte(6, 8) shouldBe 24
    }
})
