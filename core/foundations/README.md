# 🚀 Fundamentos / Foundations — Kotlin

Implementación de los ejercicios de la sección [Fundamentos / Foundations](https://yorche3.github.io/programming_languages/core/foundations/) del repositorio principal en **Kotlin (2.4)**.

---

## 📖 Descripción / Description

**ES:** Esta sección reúne los conceptos esenciales para empezar a trabajar con **Kotlin**. Cubre desde los programas más básicos (`Hello, World!` y `Hello, User!`) hasta la implementación de una calculadora con pruebas unitarias y algoritmos numéricos en tres enfoques progresivos (recursivo directo, recursivo con acumulador e iterativo).

**EN:** This section brings together the essential concepts to start working with **Kotlin**. It covers everything from the most basic programs (`Hello, World!` and `Hello, User!`) to the implementation of a calculator with unit tests and numerical algorithms in three progressive approaches (direct recursion, accumulator recursion, and iterative).

---

## 📁 Estructura / Structure

```text
kotlin/
└── core/
    └── foundations/
        ├── README.md              # Este archivo / This file
        ├── helloworld/            # 01_Hello_World — Primer programa
        │   ├── HelloWorld.kt
        │   └── README.md
        ├── hellouser/             # 02_Hello_User — Entrada y salida
        │   ├── HelloUser.kt
        │   └── README.md
        ├── unit_test/
        │   └── calculator/        # 03_Unit_Test_Calculator — Pruebas unitarias
        │       ├── build.gradle.kts
        │       ├── settings.gradle.kts
        │       ├── gradle.properties
        │       ├── src/main/kotlin/calculator/
        │       │   └── Calculator.kt
        │       ├── src/test/kotlin/calculator/
        │       │   └── CalculatorTest.kt
        │       └── README.md
        └── numbers/               # 04_Numbers — Algoritmos numéricos
            ├── build.gradle.kts
            ├── settings.gradle.kts
            ├── gradle.properties
            ├── src/main/kotlin/numbers/
            │   └── Numbers.kt
            ├── src/test/kotlin/numbers/
            │   ├── NumbersRecursiveTest.kt
            │   ├── NumbersRecursiveWithAccumulatorTest.kt
            │   └── NumbersIterativeTest.kt
            └── README.md
```

---

## 🔢 Progresión / Progression

| Especificación | Proyecto | Conceptos | Tests | Dependencias externas |
| -------------- | -------- | --------- | :---: | :-------------------: |
| [`01_Hello_World`](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) | [`helloworld/`](helloworld/) | `fun main` de nivel superior, `println`, compilación con `kotlinc` | — | ❌ Solo stdlib |
| [`02_Hello_User`](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) | [`hellouser/`](hellouser/) | `print`, `readln`, `val`, plantillas de cadena `$name` | — | ❌ Solo stdlib |
| [`03_Unit_Test_Calculator`](https://yorche3.github.io/programming_languages/core/foundations/03_Unit_Test_Calculator/) | [`unit_test/calculator/`](unit_test/calculator/) | Gradle, Kotest, `StringSpec`, `shouldBe` | 5 | ✅ Kotest (solo test) |
| [`04_Numbers`](https://yorche3.github.io/programming_languages/core/foundations/04_Numbers/) | [`numbers/`](numbers/) | Recursión, iteración, acumuladores, helpers `tailrec`, TCO | 33 | ✅ Kotest (solo test) |

---

## 🛠️ Enfoque general / General Approach

**ES:** Los proyectos en esta sección siguen un patrón progresivo:

1. **Hello World** y **Hello User**: Programas de un solo archivo, compilados con `kotlinc` y ejecutados con `kotlin` (el runner acepta el `.class` generado: `kotlin HelloWorldKt.class`), sin Gradle. Usan exclusivamente la biblioteca estándar.
2. **Calculator**: Primer proyecto con dependencia externa (**Kotest**). Introduce **Gradle** (`build.gradle.kts` + `settings.gradle.kts`), el layout estándar `src/main/kotlin` + `src/test/kotlin` y el ecosistema `gradle test`.
3. **Numbers**: Expande el patrón de Calculator a tres suites de prueba (una por enfoque). Kotlin **sí garantiza TCO** mediante el modificador `tailrec`, por lo que los tres enfoques (`_rec`, `_acc`, `_ite`) tienen pruebas directas: 33 casos.

**EN:** The projects in this section follow a progressive pattern:

1. **Hello World** and **Hello User**: Single-file programs, compiled with `kotlinc` and run with `kotlin` (the runner accepts the generated `.class`: `kotlin HelloWorldKt.class`), without Gradle. Use only the standard library.
2. **Calculator**: First project with an external dependency (**Kotest**). Introduces **Gradle** (`build.gradle.kts` + `settings.gradle.kts`), the standard `src/main/kotlin` + `src/test/kotlin` layout, and the `gradle test` ecosystem.
3. **Numbers**: Expands the Calculator pattern to three test suites (one per approach). Kotlin **does guarantee TCO** through the `tailrec` modifier, so all three approaches (`_rec`, `_acc`, `_ite`) have direct tests: 33 cases.

---

## 🚀 Ejecución rápida / Quick Start

### Hello World

```bash
cd kotlin/core/foundations/helloworld
kotlinc HelloWorld.kt && kotlin HelloWorldKt.class
```

### Hello User

```bash
cd kotlin/core/foundations/hellouser
kotlinc HelloUser.kt && kotlin HelloUserKt.class
```

### Calculator (pruebas)

```bash
cd kotlin/core/foundations/unit_test/calculator
gradle test
```

### Numbers (pruebas)

```bash
cd kotlin/core/foundations/numbers
gradle test
```

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
