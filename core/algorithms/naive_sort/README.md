# Naive Sort — Kotlin

Implementación de la especificación [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) en **Kotlin** (JVM), usando **Gradle** como herramienta de construcción y **Kotest** como framework de pruebas unitarias.

Tres algoritmos de ordenación con coste $O(n^2)$: **selection sort**, **bubble sort** e **insertion sort**, todos ordenando de forma ascendente sobre un array mutable.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.gradle.kts`](build.gradle.kts) | Script de build — plugin Kotlin JVM 2.4.10 y dependencias de test de Kotest 6.2.4. |
| [`settings.gradle.kts`](settings.gradle.kts) | Nombre del proyecto Gradle (`naive_sort`). |
| [`gradle.properties`](gradle.properties) | Opciones de Gradle (estilo de código oficial de Kotlin, memoria del daemon). |
| [`.gitignore`](.gitignore) | Ignora `build/`, `.gradle/`, `bin/` y `.kotlin/` (salidas de Gradle). |
| [`src/main/kotlin/naive_sort/NaiveSort.kt`](src/main/kotlin/naive_sort/NaiveSort.kt) | `object NaiveSort` — 3 funciones de ordenación. |
| [`src/test/kotlin/naive_sort/NaiveSortTest.kt`](src/test/kotlin/naive_sort/NaiveSortTest.kt) | Suite única: 3 tests (8 casos cada uno). |

**Estructura de directorios esperada:**

```text
naive_sort/
├── settings.gradle.kts                          # Proyecto Gradle
├── build.gradle.kts                             # Build script
├── gradle.properties                            # Opciones de Gradle
├── .gitignore                                   # Ignora build/, .gradle/, bin/ y .kotlin/
├── src/
│   ├── main/kotlin/naive_sort/
│   │   └── NaiveSort.kt                         # selectionSort, bubbleSort, insertionSort
│   └── test/kotlin/naive_sort/
│       └── NaiveSortTest.kt                     # 3 tests, 8 casos cada uno
└── build/                                       # Generado por Gradle (no versionado)
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Sigue el mismo patrón que [`numbers`](../../foundations/numbers/) y [`calculator`](../../foundations/unit_test/calculator/): proyecto Gradle con layout estándar (`src/main/kotlin` y `src/test/kotlin`) y Kotest sobre JUnit Platform. Las tres funciones se exponen como miembros de un `object` (`NaiveSort`), igual que `Numbers.kt`.

**EN:** Follows the same pattern as [`numbers`](../../foundations/numbers/) and [`calculator`](../../foundations/unit_test/calculator/): a Gradle project with standard layout (`src/main/kotlin` and `src/test/kotlin`) and Kotest on JUnit Platform. The three functions are exposed as members of an `object` (`NaiveSort`), exactly like `Numbers.kt`.

**Combinación aplicada:** algoritmo iterativo (no hay recursión en la especificación) → **1 suite × 3 tests = 3 tests (24 comprobaciones)**.

**Applied combination:** iterative algorithm (the specification contains no recursion) → **1 suite × 3 tests = 3 tests (24 assertions)**.

### Inicialización / Initialization

**ES:** El proyecto se generó con `gradle init` y después se reestructuró para alinearlo con `numbers/`: se aplanó el layout multi-proyecto (`lib/`), se sustituyó JUnit por Kotest, el paquete `org.example` pasó a `naive_sort`, y se eliminaron el wrapper (`gradlew`) y el catálogo de versiones (`gradle/libs.versions.toml`) porque ni `numbers/` ni `calculator/` los incluyen.

**EN:** The project was generated with `gradle init` and then restructured to align with `numbers/`: the multi-project layout (`lib/`) was flattened, JUnit was replaced by Kotest, the `org.example` package became `naive_sort`, and the wrapper (`gradlew`) and version catalog (`gradle/libs.versions.toml`) were removed because neither `numbers/` nor `calculator/` ship them.

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `build.gradle.kts` — Build script

```kotlin
plugins {
    kotlin("jvm") version "2.4.10"
}

group = "com.yorche3.programminglanguages"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:6.2.4")
    testImplementation("io.kotest:kotest-assertions-core:6.2.4")
}

tasks.test {
    useJUnitPlatform()
}
```

### `NaiveSort.kt` — Implementación

**ES:** Las tres funciones aceptan `IntArray?` y devuelven `IntArray?`. La firma es deliberadamente idéntica en las tres: así el helper de test puede recibir cualquiera de ellas como referencia de función (`(IntArray?) -> IntArray?`).

**EN:** All three functions take `IntArray?` and return `IntArray?`. The signature is deliberately identical across the three: this is what lets the test helper accept any of them as a function reference (`(IntArray?) -> IntArray?`).

**ES:** El archivo abre con un bloque de comentarios que documenta el contrato de las tres funciones y el tratamiento del caso nulo. Extracto de `selectionSort`:

**EN:** The file opens with a comment block documenting the contract of the three functions and the handling of the null case. Excerpt from `selectionSort`:

```kotlin
package naive_sort

object NaiveSort {
    fun selectionSort(arr: IntArray?): IntArray? {
        if (arr == null) return null
        val n = arr.size
        if (n <= 1) return arr
        for (i in 0 until n - 1) {
            var minIndex = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = arr[i]
                arr[i] = arr[minIndex]
                arr[minIndex] = temp
            }
        }
        return arr
    }
}
```

### `.gitignore` — Archivos ignorados

```text
# Gradle
.gradle/
build/
bin/

# Kotlin
.kotlin/

# IDE
.idea/
*.iml
```

---

## 🚀 Compilación y ejecución / Build & Run

### Requisitos / Requirements

- **JDK** (el build usa el JDK del sistema).
- **Gradle** 8+ (`gradle`).

```bash
java -version
gradle -version
```

### Compilar / Build

```bash
cd kotlin/core/algorithms/naive_sort
gradle compileKotlin compileTestKotlin
```

### Ejecutar las pruebas unitarias / Run tests

```bash
cd kotlin/core/algorithms/naive_sort
gradle test
```

### Salida esperada / Expected output

```text
> Task :test
BUILD SUCCESSFUL in 1s
```

El reporte detallado queda en `build/test-results/test/`:

```text
TEST-naive_sort.NaiveSortTest.xml:    tests="3" skipped="0" failures="0" errors="0"
```

Los tres `testcase` del reporte son `selection_sort`, `bubble_sort` e `insertion_sort`.

> **ES:** La compilación no emite ningún aviso (`w:`) del compilador de Kotlin.
> **EN:** The build emits no Kotlin compiler warnings (`w:`).

---

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Algoritmo | Función | Entrada ordenada | Entrada invertida |
|-----------|---------|:----------------:|:-----------------:|
| Selection sort | `selectionSort` | $O(n^2)$ | $O(n^2)$ |
| Bubble sort | `bubbleSort` | $O(n)$ (salida temprana) | $O(n^2)$ |
| Insertion sort | `insertionSort` | $O(n)$ | $O(n^2)$ |

**ES:** Los tres algoritmos operan **in-place** sobre el array recibido; no se asigna ningún array auxiliar.

**EN:** All three algorithms operate **in-place** on the received array; no auxiliary array is allocated.

### Casos cubiertos / Covered cases

| # | Entrada | Salida esperada |
|:-:|---------|-----------------|
| 1 | `[5, 2, 9, 1, 5, 6]` | `[1, 2, 5, 5, 6, 9]` |
| 2 | `[1, 2, 3, 4, 5]` | `[1, 2, 3, 4, 5]` |
| 3 | `[5, 4, 3, 2, 1]` | `[1, 2, 3, 4, 5]` |
| 4 | `[7, 7, 7, 7]` | `[7, 7, 7, 7]` |
| 5 | `[3, -1, 4, -5, 0]` | `[-5, -1, 0, 3, 4]` |
| 6 | `[42]` | `[42]` |
| 7 | `[]` | `[]` |
| 8 | `null` | `null` |

**ES:** Los 7 casos obligatorios de la especificación más el caso `null`, que aquí **sí es representable** porque el tipo de entrada es `IntArray?`.

**EN:** The 7 mandatory cases from the specification plus the `null` case, which **is representable here** because the input type is `IntArray?`.

---

## 📝 Notas de implementación / Implementation Notes

### 🧬 Ordenamiento *in-place* / In-place sorting

**ES:** `IntArray` es mutable y se pasa por referencia en la JVM, así que las tres funciones reordenan el array recibido y devuelven ese mismo array. Los tests aíslan cada caso copiando la entrada con `case.input?.copyOf()` antes de invocar la función, de modo que un caso no contamine los siguientes.

**EN:** `IntArray` is mutable and passed by reference on the JVM, so all three functions reorder the received array and return that same array. The tests isolate each case by copying the input with `case.input?.copyOf()` before invoking the function, so one case cannot contaminate the next.

### 🆗 Indicador de fallo con `null` / Failure indicator via `null`

**ES:** La especificación exige un indicador de fallo y prohíbe lanzar excepciones. El tipo `IntArray?` admite `null`, por lo que la comprobación `if (arr == null) return null` es idiomática y no requiere mecanismos artificiales. El caso `null` se prueba de forma independiente del caso vacío (`[]`).

**EN:** The specification requires a failure indicator and forbids throwing exceptions. The `IntArray?` type admits `null`, so the `if (arr == null) return null` check is idiomatic and needs no artificial mechanism. The `null` case is tested independently from the empty case (`[]`).

### 🔁 La bandera `swapped` con `break` / The `swapped` flag with `break`

**ES:** `bubbleSort` mantiene la bandera `swapped` que exige la especificación: si una pasada completa no realiza ningún intercambio, el array ya está ordenado y el bucle se corta con `if (!swapped) break`. Es lo que convierte el mejor caso en $O(n)$.

**EN:** `bubbleSort` keeps the `swapped` flag required by the specification: if a full pass performs no swap, the array is already sorted and the loop is cut with `if (!swapped) break`. This is what makes the best case $O(n)$.

### ➿ Cotas de los bucles / Loop bounds

**ES:** Las cotas reproducen literalmente las del pseudocódigo usando rangos semiabiertos de Kotlin (`until`), que ya excluyen el extremo superior: `0 until n - 1` para el bucle externo de selection y bubble, `i + 1 until n` para la búsqueda del mínimo e `0 until n - i - 1` para la pasada interna de bubble. No hay desplazamientos manuales con `-1` ni `+1` que justificar.

**EN:** The bounds reproduce the pseudocode's literally using Kotlin's half-open ranges (`until`), which already exclude the upper end: `0 until n - 1` for the outer loop of selection and bubble, `i + 1 until n` for the minimum search and `0 until n - i - 1` for bubble's inner pass. There are no manual `-1`/`+1` offsets to justify.

### 🔀 Estabilidad de `insertionSort` / `insertionSort` stability

**ES:** El bucle interno se detiene con la comparación estricta `arr[j] > key`; los elementos iguales no se desplazan, por lo que `insertionSort` es estable. El caso 1 (`[5, 2, 9, 1, 5, 6]`, con dos cincos) se beneficia de ello, aunque la comparación de los tests se hace sobre valores y no sobre identidad.

**EN:** The inner loop stops on the strict comparison `arr[j] > key`; equal elements do not shift, so `insertionSort` is stable. Case 1 (`[5, 2, 9, 1, 5, 6]`, with two fives) benefits from it, although the tests compare values rather than identity.

### 🏷️ Naming y visibilidad / Naming and visibility

**ES:** Se usa `camelCase` para las funciones (`selectionSort`) porque es la convención de Kotlin, mientras que la especificación las nombra en `snake_case` (`selection_sort`). El nombre de la especificación se conserva como **nombre del test**, de forma que el reporte sigue mostrando `selection_sort`, `bubble_sort` e `insertion_sort`.

**EN:** Functions use `camelCase` (`selectionSort`) because that is Kotlin's convention, while the specification names them in `snake_case` (`selection_sort`). The specification name is preserved as the **test name**, so the report still shows `selection_sort`, `bubble_sort` and `insertion_sort`.

### 🧪 Estructura de los tests / Test structure

**ES:** Una única suite con 3 tests en `StringSpec`. Los 8 casos viven en una lista de constantes compartida y un único helper los recorre para cualquier función:

**EN:** A single suite with 3 tests in `StringSpec`. The 8 cases live in a shared list of constants and a single helper walks them for any function:

```kotlin
private fun assertSortsAllCases(sort: (IntArray?) -> IntArray?, algorithm: String) {
    cases.forEach { case ->
        withClue("$algorithm should sort ${case.description}") {
            val actual = sort(case.input?.copyOf())
            actual?.toList() shouldBe case.expected?.toList()
        }
    }
}
```

**ES:** Dos detalles importantes: (1) la comparación usa `.toList()` porque `IntArray` no sobrescribe `equals`, de modo que comparar arrays directamente sería comparar referencias; (2) `withClue` antepone el mensaje exigido por el contrato de tests (`"{algorithm} should sort an unsorted array"`) al fallo de Kotest, lo que permite identificar el algoritmo y el caso que falló.

**EN:** Two important details: (1) the comparison uses `.toList()` because `IntArray` does not override `equals`, so comparing arrays directly would compare references; (2) `withClue` prefixes the failure with the message required by the test contract (`"{algorithm} should sort an unsorted array"`), making it possible to identify the algorithm and the failing case.

Las tres llamadas del test usan referencias de método, sin lambdas intermedias:

```kotlin
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
```

### 📍 Desviaciones respecto a la ubicación esperada / Deviations from the expected location

| Especificación | Implementación | Motivo |
|----------------|----------------|--------|
| `src/naive_sort.ext` | `src/main/kotlin/naive_sort/NaiveSort.kt` | Layout estándar de Gradle; el archivo se nombra en `PascalCase` como `Numbers.kt` en `numbers/`. |
| `test/naive_sort_test.ext` | `src/test/kotlin/naive_sort/NaiveSortTest.kt` | Layout estándar de Gradle; sufijo `Test` como `NumbersIterativeTest.kt`. |
| `test/run_tests.ext` | *(no existe)* | Gradle descubre y ejecuta la suite a través de JUnit Platform. Ni `numbers/` ni `calculator/` incluyen un runner propio. |

**ES:** Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

**EN:** This project is also implemented in other languages. Explore the main repository to see the other versions.

---

*[← Volver a Algoritmos Puros](../README.md) · [↑ Volver a Core](../../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
