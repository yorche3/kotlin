# Numbers — Kotlin

Implementación de la especificación [04_Numbers](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) en **Kotlin**, usando **Gradle** como herramienta de construcción y **Kotest** como framework de pruebas unitarias.

Tres enfoques de implementación para los mismos 5 algoritmos: **recursivo directo** (`Rec`), **recursivo con acumulador** (`Acc`) e **iterativo** (`Ite`).

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.gradle.kts`](build.gradle.kts) | Script de build — plugin Kotlin JVM 2.4.10 y dependencias de test de Kotest 6.2.4. |
| [`settings.gradle.kts`](settings.gradle.kts) | Nombre del proyecto Gradle (`numbers`). |
| [`gradle.properties`](gradle.properties) | Opciones de Gradle (estilo de código oficial de Kotlin, memoria del daemon). |
| [`.gitignore`](.gitignore) | Ignora `build/`, `.gradle/` y `.kotlin/` (salidas de Gradle). |
| [`src/main/kotlin/numbers/Numbers.kt`](src/main/kotlin/numbers/Numbers.kt) | `object Numbers` — 15 funciones (3 enfoques × 5 algoritmos) + 4 helpers `private tailrec`. |
| [`src/test/kotlin/numbers/NumbersRecursiveTest.kt`](src/test/kotlin/numbers/NumbersRecursiveTest.kt) | Suite recursiva: 11 casos. |
| [`src/test/kotlin/numbers/NumbersRecursiveWithAccumulatorTest.kt`](src/test/kotlin/numbers/NumbersRecursiveWithAccumulatorTest.kt) | Suite con acumulador: 11 casos. |
| [`src/test/kotlin/numbers/NumbersIterativeTest.kt`](src/test/kotlin/numbers/NumbersIterativeTest.kt) | Suite iterativa: 11 casos. |

**Estructura de directorios esperada:**

```text
numbers/
├── settings.gradle.kts                          # Proyecto Gradle
├── build.gradle.kts                             # Build script
├── gradle.properties                            # Opciones de Gradle
├── .gitignore                                   # Ignora build/ y .gradle/
├── src/
│   ├── main/kotlin/numbers/
│   │   └── Numbers.kt                           # 15 funciones + 4 helpers tailrec
│   └── test/kotlin/numbers/
│       ├── NumbersRecursiveTest.kt              # Tests recursivos (11 casos)
│       ├── NumbersRecursiveWithAccumulatorTest.kt  # Tests con acumulador (11 casos)
│       └── NumbersIterativeTest.kt              # Tests iterativos (11 casos)
└── build/                                       # Generado por Gradle (no versionado)
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Sigue el mismo patrón que [`calculator`](../unit_test/calculator/): proyecto Gradle con layout estándar (`src/main/kotlin` y `src/test/kotlin`) y Kotest. Las 15 funciones se organizan en 3 grupos por enfoque:

| Enfoque | Sufijo | Ejemplo | ¿Tiene tests directos? |
| ------- | ------ | ------- | :---------------------: |
| Recursivo directo | `...Rec` | `fibonacciRec(n)` | ✅ Sí |
| Recursivo con acumulador | `...Acc` | `fibonacciAcc(n)` | ✅ Sí (ver nota TCO) |
| Iterativo | `...Ite` | `fibonacciIte(n)` | ✅ Sí |

**EN:** Follows the same pattern as [`calculator`](../unit_test/calculator/): a Gradle project with standard layout (`src/main/kotlin` and `src/test/kotlin`) and Kotest. The 15 functions are organized into 3 groups by approach:

| Approach | Suffix | Example | Direct tests? |
| -------- | ------ | ------- | :-----------: |
| Direct recursion | `...Rec` | `fibonacciRec(n)` | ✅ Yes |
| Accumulator recursion | `...Acc` | `fibonacciAcc(n)` | ✅ Yes (see TCO note) |
| Iterative | `...Ite` | `fibonacciIte(n)` | ✅ Yes |

**Combinación aplicada:** TCO ✅ + iteración ✅ → `_rec` + `_acc` + `_ite` = **33 pruebas**.

**Applied combination:** TCO ✅ + iteration ✅ → `_rec` + `_acc` + `_ite` = **33 tests**.

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `Numbers.kt` — Implementación

**ES:** Cada algoritmo tiene 3 implementaciones en un único archivo. Los helpers del enfoque con acumulador son `private tailrec` (encapsulados en el `object`). Por ejemplo, `fibonacci`:

**EN:** Each algorithm has 3 implementations in a single file. The accumulator helpers are `private tailrec` (encapsulated in the `object`). For example, `fibonacci`:

```kotlin
// Enfoque recursivo directo / Direct recursion
fun fibonacciRec(n: Int): Int {
    if (n <= 1) {
        return n
    }
    return fibonacciRec(n - 1) + fibonacciRec(n - 2)
}

// Enfoque con acumulador / Accumulator recursion
fun fibonacciAcc(n: Int): Int = fibonacciAccHelp(n, 0, 1)

// Helper privado con acumulador / Private accumulator helper
private tailrec fun fibonacciAccHelp(n: Int, acc2: Int, acc1: Int): Int {
    if (n <= 0) {
        return acc2
    }
    if (n <= 2) {
        return acc1 + acc2
    }
    return fibonacciAccHelp(n - 1, acc1, acc1 + acc2)
}

// Enfoque iterativo / Iterative
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
```

| Algoritmo | `Rec` | `Acc` | `Ite` |
| --------- | ----- | ----- | ----- |
| `sumOfFirstN` | `n + sumRec(n-1)` | helper `tailrec` con `acc + n` | bucle `1..n` |
| `factorial` | `n * factRec(n-1)` | helper `tailrec` con `acc * n` | bucle `2..n` |
| `fibonacci` | `fibRec(n-1) + fibRec(n-2)` | helper `tailrec` con `acc2, acc1` | bucle de intercambio |
| `greatestCommonDivisor` | Euclides recursivo | helper `tailrec` (Euclides) | Euclides con `while (y != 0)` |
| `leastCommonMultiple` | `(a*b) / gcdRec` | `(a*b) / gcdAcc` | `(a*b) / gcdIte` |

### Suites de pruebas — Kotest

**ES:** Tres suites `StringSpec`, una por enfoque, con los mismos 11 casos del pseudocódigo de la especificación (33 en total).

**EN:** Three `StringSpec` suites, one per approach, with the same 11 cases from the specification pseudocode (33 in total).

```kotlin
"fibonacciRec(6) returns 8" {
    Numbers.fibonacciRec(6) shouldBe 8
}

"fibonacciAcc(6) returns 8" {
    Numbers.fibonacciAcc(6) shouldBe 8
}

"fibonacciIte(6) returns 8" {
    Numbers.fibonacciIte(6) shouldBe 8
}
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

### Ejecutar las pruebas unitarias / Run tests

```bash
cd kotlin/core/foundations/numbers
gradle test
```

### Salida esperada / Expected output

```text
> Task :test
BUILD SUCCESSFUL in 3s
```

El reporte detallado queda en `build/test-results/test/`:

```text
TEST-numbers.NumbersRecursiveTest.xml:                   tests="11" skipped="0" failures="0" errors="0"
TEST-numbers.NumbersRecursiveWithAccumulatorTest.xml:    tests="11" skipped="0" failures="0" errors="0"
TEST-numbers.NumbersIterativeTest.xml:                   tests="11" skipped="0" failures="0" errors="0"
```

> **ES:** 33 pruebas en total: 11 casos por enfoque, todos pasando.
> **EN:** 33 tests in total: 11 cases per approach, all passing.

---

## 🔁 Sobre recursión con acumulador y Tail Call Optimization (TCO)

**ES:**
Tail recursion ocurre cuando la llamada recursiva es la última acción que ejecuta una función; después de la llamada no hay más instrucciones. La recursión con acumulador consigue esto pasando el estado previo como parámetro, sin dejar trabajo pendiente en la pila.

En Kotlin, **sí se garantiza TCO** mediante el modificador `tailrec`: el compilador verifica que la llamada recursiva esté en posición de cola (si no lo está, emite un error de compilación) y transforma la función en un bucle, eliminando el consumo de pila. Los helpers `_acc` están declarados `tailrec`, por lo que su coste en pila es equivalente al de la versión iterativa. Por eso **sí se desarrollan pruebas unitarias específicas para las funciones `_acc`** (11 casos).

**EN:**
Tail recursion occurs when the recursive call is the last action executed by a function; after the call there are no more instructions. Accumulator recursion achieves this by passing the previous state as a parameter, leaving no pending work on the stack.

In Kotlin, **TCO is guaranteed** through the `tailrec` modifier: the compiler verifies that the recursive call is in tail position (if not, it raises a compilation error) and transforms the function into a loop, eliminating stack consumption. The `_acc` helpers are declared `tailrec`, so their stack cost is equivalent to the iterative version. This is why **dedicated unit tests are written for the `_acc` functions** (11 cases).

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** El proyecto no usa `main()`: el "punto de entrada" es el runner de Kotest (a través de JUnit Platform con `gradle test`), que descubre y ejecuta las suites automáticamente.
- **EN:** The project has no `main()`: the "entry point" is Kotest's runner (via JUnit Platform with `gradle test`), which discovers and executes the suites automatically.
- **ES:** `Numbers` es un `object` (singleton) con funciones de instancia; los helpers son `private` y quedan ocultos fuera del módulo.
- **EN:** `Numbers` is an `object` (singleton) with instance functions; helpers are `private` and hidden outside the module.
- **ES:** `lcm` usa división entera (`/`), por lo que `(a * b) / gcd(a, b)` es exacta sin pasar por `Double`.
- **EN:** `lcm` uses integer division (`/`), so `(a * b) / gcd(a, b)` is exact without going through `Double`.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
