package naive_sort

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// Casos de prueba de la especificación 05_Naive_Sort.md
private val standardInput = intArrayOf(5, 2, 9, 1, 5, 6)
private val standardOutput = intArrayOf(1, 2, 5, 5, 6, 9)

private val sortedInput = intArrayOf(1, 2, 3, 4, 5)
private val sortedOutput = intArrayOf(1, 2, 3, 4, 5)

private val reverseInput = intArrayOf(5, 4, 3, 2, 1)
private val reverseOutput = intArrayOf(1, 2, 3, 4, 5)

private val identicalInput = intArrayOf(7, 7, 7, 7)
private val identicalOutput = intArrayOf(7, 7, 7, 7)

private val negativeInput = intArrayOf(3, -1, 4, -5, 0)
private val negativeOutput = intArrayOf(-5, -1, 0, 3, 4)

private val singleInput = intArrayOf(42)
private val singleOutput = intArrayOf(42)

private val emptyInput = intArrayOf()
private val emptyOutput = intArrayOf()

private data class SortCase(
    val description: String,
    val input: IntArray?,
    val expected: IntArray?,
)

private val cases = listOf(
    SortCase("an unsorted array", standardInput, standardOutput),
    SortCase("an already sorted array", sortedInput, sortedOutput),
    SortCase("a reverse ordered array", reverseInput, reverseOutput),
    SortCase("an array of identical elements", identicalInput, identicalOutput),
    SortCase("an array with negative numbers", negativeInput, negativeOutput),
    SortCase("a single element array", singleInput, singleOutput),
    SortCase("an empty array", emptyInput, emptyOutput),
    SortCase("a null input", null, null),
)

// Helper compartido: recibe la función a probar y el nombre del algoritmo, y ejecuta
// todos los casos con un mensaje descriptivo cada uno.
//
// Caso nulo incluido: `IntArray?` admite `null`, y el contrato lo devuelve como
// indicador de fallo en lugar de lanzar una excepción.
//
// Cada caso ordena una copia del fixture (`copyOf`), porque los algoritmos pueden
// ordenar in-place y los arrays de Kotlin son mutables.
//
// La comparación convierte a `List<Int>` porque los arrays de Kotlin usan igualdad
// por referencia: `shouldBe` sobre arrays compararía identidades, no contenidos.
private fun assertSortsAllCases(sort: (IntArray?) -> IntArray?, algorithm: String) {
    cases.forEach { case ->
        withClue("$algorithm should sort ${case.description}") {
            val actual = sort(case.input?.copyOf())
            actual?.toList() shouldBe case.expected?.toList()
        }
    }
}

class NaiveSortTest : StringSpec({

    "selection_sort" {
        assertSortsAllCases(NaiveSort::selectionSort, "selection_sort")
    }

    "bubble_sort" {
        assertSortsAllCases(NaiveSort::bubbleSort, "bubble_sort")
    }

    "insertion_sort" {
        assertSortsAllCases(NaiveSort::insertionSort, "insertion_sort")
    }
})
