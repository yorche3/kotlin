# Calculator — Kotlin

Implementación de la especificación [03_Unit_Test_Calculator](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) en **Kotlin**, usando **Gradle** como herramienta de construcción y **Kotest** como framework de pruebas unitarias.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`build.gradle.kts`](build.gradle.kts) | Script de build — plugin Kotlin JVM 2.4.10 y dependencias de test de Kotest 6.2.4. |
| [`settings.gradle.kts`](settings.gradle.kts) | Nombre del proyecto Gradle (`calculator`). |
| [`gradle.properties`](gradle.properties) | Opciones de Gradle (estilo de código oficial de Kotlin, memoria del daemon). |
| [`.gitignore`](.gitignore) | Ignora `build/`, `.gradle/` y `.kotlin/` (salidas de Gradle). |
| [`src/main/kotlin/calculator/Calculator.kt`](src/main/kotlin/calculator/Calculator.kt) | Clase `Calculator` con las 5 operaciones aritméticas. |
| [`src/test/kotlin/calculator/CalculatorTest.kt`](src/test/kotlin/calculator/CalculatorTest.kt) | 5 pruebas unitarias con Kotest (`StringSpec` + `shouldBe`). |

**Estructura de directorios esperada:**

```text
calculator/
├── settings.gradle.kts                  # Proyecto Gradle
├── build.gradle.kts                     # Build script
├── gradle.properties                    # Opciones de Gradle
├── .gitignore                           # Ignora build/ y .gradle/
├── src/
│   ├── main/kotlin/calculator/
│   │   └── Calculator.kt                # 5 operaciones aritméticas
│   └── test/kotlin/calculator/
│       └── CalculatorTest.kt            # 5 tests con Kotest
└── build/                               # Generado por Gradle (no versionado)
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Este proyecto usa **Gradle** con el layout estándar (`src/main/kotlin` para fuentes y `src/test/kotlin` para pruebas) y **Kotest**:

1. Cada operación de `Calculator` es un método de instancia de la clase `Calculator`.
2. Cada prueba es un caso de `StringSpec` y verifica con `shouldBe`.
3. El descubrimiento de pruebas es automático: `gradle test` ejecuta todas las clases de test a través del runner JUnit Platform de Kotest.
4. `multiplication`, `division` y `modulus` se implementan con las estrategias educativas de la especificación (sin usar los operadores `*`, `/` ni `%` respectivamente).

**EN:** This project uses **Gradle** with the standard layout (`src/main/kotlin` for sources and `src/test/kotlin` for tests) and **Kotest**:

1. Each `Calculator` operation is an instance method of the `Calculator` class.
2. Each test is a `StringSpec` case and verifies with `shouldBe`.
3. Test discovery is automatic: `gradle test` runs all test classes through Kotest's JUnit Platform runner.
4. `multiplication`, `division` and `modulus` are implemented with the educational strategies from the specification (without using the `*`, `/` or `%` operators respectively).

---

## 📄 Archivos de configuración clave / Key Configuration Files

### `build.gradle.kts` — Build script de Gradle

**ES:** Aplica el plugin `kotlin("jvm")` versión 2.4.10 y declara las dos dependencias de test de Kotest (runner JUnit 5 y aserciones). `useJUnitPlatform()` activa el motor de test.

**EN:** Applies the `kotlin("jvm")` plugin version 2.4.10 and declares the two Kotest test dependencies (JUnit 5 runner and assertions). `useJUnitPlatform()` enables the test engine.

```kotlin
plugins {
    kotlin("jvm") version "2.4.10"
}

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

### `Calculator.kt` — Módulo principal

| Operación | Implementación educativa |
| --------- | ------------------------ |
| `addition(a, b)` | Suma directa (`a + b`). |
| `subtraction(a, b)` | Resta directa (`a - b`). |
| `multiplication(a, b)` | Suma repetitiva: acumula `a`, `b` veces con `repeat` (no usa `*`). |
| `division(a, b)` | Resta repetitiva: resta `b` de `a` mientras `a >= b` (no usa `/`). |
| `modulus(a, b)` | Construida sobre `division` y `multiplication` (no usa `%`). |

```kotlin
package calculator

class Calculator {
    fun addition(a: Int, b: Int): Int = a + b

    fun subtraction(a: Int, b: Int): Int = a - b

    fun multiplication(a: Int, b: Int): Int {
        var result = 0
        repeat(b) {
            result = addition(result, a)
        }
        return result
    }

    fun division(a: Int, b: Int): Int {
        var remaining = a
        var count = 0
        while (remaining >= b) {
            remaining = subtraction(remaining, b)
            count = addition(count, 1)
        }
        return count
    }

    fun modulus(a: Int, b: Int): Int {
        val q = division(a, b)
        val p = multiplication(q, b)
        return subtraction(a, p)
    }
}
```

### `CalculatorTest.kt` — Pruebas unitarias (Kotest)

**ES:** Un caso de `StringSpec` por operación, con los mismos casos del pseudocódigo de la especificación.

**EN:** One `StringSpec` case per operation, with the same cases as the specification pseudocode.

```kotlin
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
cd kotlin/core/foundations/unit_test/calculator
gradle test
```

### Salida esperada / Expected output

```text
> Task :test
BUILD SUCCESSFUL in 31s
```

El reporte detallado queda en `build/test-results/test/TEST-calculator.CalculatorTest.xml`:

```text
tests="5" skipped="0" failures="0" errors="0"
```

---

## 📝 Notas de implementación / Implementation Notes

**ES:** El proyecto no usa `main()`: el "punto de entrada" es el propio runner de Kotest (a través de JUnit Platform con `gradle test`), que descubre y ejecuta la suite automáticamente. El código de producción solo depende de la biblioteca estándar de Kotlin; Kotest es dependencia exclusiva de `testImplementation`.

**EN:** The project has no `main()`: the "entry point" is Kotest's runner itself (via JUnit Platform with `gradle test`), which discovers and executes the suite automatically. Production code depends only on the Kotlin standard library; Kotest is an exclusive `testImplementation` dependency.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
