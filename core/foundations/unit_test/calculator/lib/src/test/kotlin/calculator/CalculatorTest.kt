package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "addition(2, 3) returns 5" {
        Calculator().addition(2, 3) shouldBe 5
    }

    "subtraction(5, 2) returns 3" {
        Calculator().subtraction(5, 2) shouldBe 3
    }

    "multiplication(3, 4) returns 12" {
        Calculator().multiplication(3, 4) shouldBe 12
    }

    "division(10, 3) returns 3" {
        Calculator().division(10, 3) shouldBe 3
    }

    "modulus(10, 3) returns 1" {
        Calculator().modulus(10, 3) shouldBe 1
    }
})
