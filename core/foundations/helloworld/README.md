# Hello, World! — Kotlin

Implementación de la especificación [01_Hello_World](https://yorche3.github.io/programming_languages/core/foundations/01_Hello_World/) en **Kotlin**, con un enfoque manual y minimalista.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`HelloWorld.kt`](HelloWorld.kt) | Código fuente: función `main` que imprime `"Hello, World! from Kotlin!"`. |
| `HelloWorldKt.class` | Bytecode JVM generado por `kotlinc` (no versionado). |
| `HelloWorld.jar` | Archivo JAR ejecutable generado con `-include-runtime` (no versionado). |

**Estructura de directorios esperada:**

```text
helloworld/
├── HelloWorld.kt        # Código fuente
├── HelloWorldKt.class   # Bytecode compilado (generado por kotlinc)
├── HelloWorld.jar       # JAR ejecutable (generado, opcional)
└── README.md            # Este archivo
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó manualmente, sin herramientas de scaffolding (Gradle/Maven), para mantener la máxima sencillez. Un único archivo `.kt` con una función `main` de nivel superior es suficiente para compilar y ejecutar con el compilador de línea de comandos (`kotlinc`).

**EN:** The project was created manually, without scaffolding tools (Gradle/Maven), to keep it as simple as possible. A single `.kt` file with a top-level `main` function is enough to compile and run with the command-line compiler (`kotlinc`).

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p kotlin/core/foundations/helloworld
   ```

2. Escribir el archivo `HelloWorld.kt` con el código fuente.

3. No se necesita ningún paso adicional de construcción o vinculación de dependencias.

### Requisitos / Requirements

- **JDK** (Kotlin compila a bytecode JVM).
- **Kotlin Compiler** (`kotlinc`) y el runner `kotlin`.

```bash
# Verificar instalación
kotlinc -version
```

---

## 📄 Archivos de configuración clave / Key Configuration Files

No se requieren archivos de configuración de build. El compilador (`kotlinc`) y el runner (`kotlin` / `java`) se invocan directamente desde línea de comandos.

```kotlin
fun main(args : Array<String>) {
  println("Hello, World! from Kotlin!");
}
```

| Elemento | Propósito |
|----------|-----------|
| `fun main(args : Array<String>)` | Punto de entrada del programa (función de nivel superior, sin necesidad de clase). |
| `args : Array<String>` | Parámetro que recibe los argumentos de línea de comandos. |
| `println(...)` | Imprime una línea con salto de línea al final en la salida estándar. |

> **ES:** Al declarar `main` a nivel de archivo (sin clase), el compilador genera la clase `HelloWorldKt`, cuyo nombre deriva del archivo `HelloWorld.kt`.
> **EN:** By declaring `main` at file level (no class), the compiler generates the class `HelloWorldKt`, whose name derives from the file `HelloWorld.kt`.

---

## 🚀 Compilación y ejecución / Build & Run

### Opción A — JAR ejecutable (recomendada) / Option A — Executable JAR (recommended)

```bash
cd kotlin/core/foundations/helloworld
kotlinc HelloWorld.kt -include-runtime -d HelloWorld.jar
java -jar HelloWorld.jar
```

### Opción B — Compilar y ejecutar con el runner de Kotlin / Option B — Compile and run with the Kotlin runner

```bash
cd kotlin/core/foundations/helloworld
kotlinc HelloWorld.kt
kotlin HelloWorldKt.class
```

> **ES:** Con versiones recientes de Kotlin (2.x), el runner `kotlin` acepta directamente el archivo `.class` generado: `kotlin HelloWorldKt.class`. En versiones anteriores se invoca el nombre de la clase sin extensión: `kotlin HelloWorldKt`.
> **EN:** With recent Kotlin versions (2.x), the `kotlin` runner accepts the generated `.class` file directly: `kotlin HelloWorldKt.class`. In older versions, the class name is invoked without the extension: `kotlin HelloWorldKt`.

### Salida esperada / Expected output

```text
Hello, World! from Kotlin!
```

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Kotlin compila a bytecode JVM; el programa necesita una JVM para ejecutarse. La opción `-include-runtime` empaqueta el runtime de Kotlin dentro del JAR para que sea autocontenido.
- **EN:** Kotlin compiles to JVM bytecode; the program needs a JVM to run. The `-include-runtime` option bundles the Kotlin runtime inside the JAR so it is self-contained.
- **ES:** La función `main` de nivel superior es idiomática en Kotlin desde la versión 1.3; no es obligatorio envolverla en una clase.
- **EN:** The top-level `main` function is idiomatic in Kotlin since version 1.3; wrapping it in a class is not required.
- **ES:** El tipo del parámetro `args` se declara después del nombre con `:`. La inferencia de tipos es una característica central de Kotlin.
- **EN:** The type of the `args` parameter is declared after the name with `:`. Type inference is a core Kotlin feature.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
