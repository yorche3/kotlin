# Algorithms Pure — Kotlin

Implementaciones de la [Fase 1 — Algoritmos Puros](https://yorche3.github.io/programming_languages/ROADMAP/#fase-1--algoritmos-puros--algorithms-pure-) en **Kotlin**: ordenamientos elementales, estructuras de datos propias, ordenamientos óptimos y distribuidos, y búsqueda.

Los módulos de esta fase trabajan sobre `IntArray`, que en la JVM **es mutable**, **se indexa desde 0** y admite `null` como indicador de fallo.

---

## 📂 Módulos / Modules

| Módulo | Especificación | Enfoque | Tests | Estado |
|--------|---------------|---------|:-----:|:------:|
| [`naive_sort/`](naive_sort/) | [05_Naive_Sort](https://yorche3.github.io/programming_languages/core/algorithms/05_Naive_Sort/) | `gradle test` + Kotest | 3 | ✅ |

---

## 📁 Estructura / Structure

```text
algorithms/
└── naive_sort/                        # 05_Naive_Sort
    ├── build.gradle.kts               # Plugin Kotlin JVM + dependencias de Kotest
    ├── settings.gradle.kts            # rootProject.name = "naive_sort"
    ├── gradle.properties              # Opciones de Gradle
    ├── .gitignore                     # build/, .gradle/, bin/, .kotlin/
    ├── src/
    │   ├── main/kotlin/naive_sort/
    │   │   └── NaiveSort.kt           # selectionSort, bubbleSort, insertionSort
    │   └── test/kotlin/naive_sort/
    │       └── NaiveSortTest.kt       # 3 tests × 8 casos
    └── README.md
```

---

## 🛠️ Patrón común / Common Pattern

| Característica | Descripción |
|---------------|-------------|
| **Runtime** | Kotlin/JVM 2.4.10 sobre la JVM del sistema; se compila a *bytecode* |
| **CLI** | `gradle test` |
| **Build script** | `build.gradle.kts` — plugin `kotlin("jvm")` versionado en línea, sin catálogo de versiones |
| **Framework de tests** | Kotest 6.2.4 (`kotest-runner-junit5` + `kotest-assertions-core`) sobre JUnit Platform |
| **Configuración de test** | `tasks.test { useJUnitPlatform() }`; no hay runner propio |
| **Separación** | `src/main/kotlin/{paquete}/` (objeto) ↔ `src/test/kotlin/{paquete}/` (suite) |
| **Iteración** | Bucles `for (i in … until …)` y `while` nativos sobre `IntArray` |
| **Indexación** | **0-based**, como el pseudocódigo |
| **Visibilidad** | `object` con funciones públicas; helpers y constantes de test en `private` |
| **Naming** | `camelCase` para funciones (`selectionSort`); el nombre de la especificación se conserva como nombre del test |
| **Indicador de fallo** | `null` sobre el tipo nullable `IntArray?` — se devuelve tal cual, sin lanzar excepciones |
| **Artefactos** | `build/`, `.gradle/`, `bin/`, `.kotlin/` — ignorados por el `.gitignore` del módulo |

---

## 🚀 Compilación rápida / Quick Build

```bash
# Naive Sort Tests
cd naive_sort
gradle test
```

---

## ▶️ Siguiente / Next

👉 Continúa con los módulos pendientes de esta fase en el [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).
👉 Continue with the pending modules of this phase in the [Roadmap](https://yorche3.github.io/programming_languages/ROADMAP/).

---

*[← Volver a Core](../README.md)*

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
