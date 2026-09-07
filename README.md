# Kotlin

Proyectos en **Kotlin (2.4)**, con programas simples compilados con `kotlinc` y proyectos con pruebas unitarias gestionados con **Gradle** y el framework **Kotest**.

---

## 📂 Módulos / Modules

| Módulo | Descripción |
| ------ | ----------- |
| [`core/foundations/`](core/foundations/) | **Fase 0 — Fundamentos**: `helloworld`, `hellouser`, `unit_test/calculator`, `numbers` |

---

## ▶️ Comenzar / Getting Started

```bash
# Hello, World!
cd core/foundations/helloworld
kotlinc HelloWorld.kt && kotlin HelloWorldKt.class

# Hello, User!
cd core/foundations/hellouser
kotlinc HelloUser.kt && kotlin HelloUserKt.class

# Calculator Tests
cd core/foundations/unit_test/calculator
gradle test

# Numbers Tests
cd core/foundations/numbers
gradle test
```

---

## 📦 Requisitos / Requirements

| Herramienta | Instalación |
| ----------- | ----------- |
| [JDK](https://adoptium.net/) | `sudo apt install openjdk-21-jdk` (Linux) / [Descargar](https://adoptium.net/) |
| [Kotlin Compiler](https://kotlinlang.org/docs/command-line.html) | `sudo snap install kotlin` (Linux) / [Descargar](https://github.com/JetBrains/kotlin/releases) |
| [Gradle 8+](https://gradle.org/install/) | `sdk install gradle` (SDKMAN) / `sudo apt install gradle` (Linux) / [Descargar](https://gradle.org/install/) |

```bash
# Verificar instalación
kotlinc -version
gradle -version
```

---

## 🏗️ Tipos de proyecto / Project Types

### 1. Programa simple (compilación directa con `kotlinc`)

**ES:** Un único archivo fuente, sin dependencias externas, compilado directamente con `kotlinc` y ejecutado con `kotlin`. Ideal para `helloworld` y `hellouser`. No requiere Gradle. Con Kotlin 2.x, el runner acepta el `.class` generado: `kotlin HelloWorldKt.class`.

**EN:** A single source file, no external dependencies, compiled directly with `kotlinc` and run with `kotlin`. Ideal for `helloworld` and `hellouser`. No Gradle required. With Kotlin 2.x, the runner accepts the generated `.class`: `kotlin HelloWorldKt.class`.

```bash
kotlinc <File>.kt
kotlin <File>Kt.class
```

### 2. Proyecto con pruebas unitarias (Gradle + Kotest)

**ES:** Para proyectos que requieren pruebas unitarias, se usa **Gradle** (`build.gradle.kts` + `settings.gradle.kts`) y **Kotest** como dependencia de test. El código fuente se organiza en `src/main/kotlin` y las pruebas en `src/test/kotlin`, con descubrimiento automático de tests mediante el runner JUnit Platform de Kotest.

**EN:** For projects that require unit tests, **Gradle** (`build.gradle.kts` + `settings.gradle.kts`) and **Kotest** are used as a test dependency. Source code goes in `src/main/kotlin` and tests in `src/test/kotlin`, with automatic test discovery via Kotest's JUnit Platform runner.

```bash
gradle test
```

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*