# Hello, User! — Kotlin

Implementación de la especificación [02_Hello_User](https://yorche3.github.io/programming_languages/core/foundations/02_Hello_User/) en **Kotlin**, con un enfoque manual y minimalista.

Lee un nombre desde la entrada estándar y saluda al usuario.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo | Propósito |
|---------|-----------|
| [`HelloUser.kt`](HelloUser.kt) | Código fuente: solicita un nombre al usuario y saluda. |
| `HelloUserKt.class` | Bytecode JVM generado por `kotlinc` (no versionado). |
| `HelloUser.jar` | Archivo JAR ejecutable generado con `-include-runtime` (no versionado). |

**Estructura de directorios esperada:**

```text
hellouser/
├── HelloUser.kt        # Código fuente
├── HelloUserKt.class   # Bytecode compilado (generado por kotlinc)
├── HelloUser.jar       # JAR ejecutable (generado, opcional)
└── README.md           # Este archivo
```

---

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** Este programa introduce tres conceptos nuevos respecto a `helloworld`:

1. **Entrada de usuario** — `readln()` lee una línea desde la entrada estándar.
2. **Variable inmutable** — `val name` declara una variable de solo lectura; su tipo `String` se infiere automáticamente.
3. **Plantillas de cadenas** — `"Hello, $name!"` interpola el valor de `name` dentro de la cadena.

**EN:** This program introduces three new concepts compared to `helloworld`:

1. **User input** — `readln()` reads a line from standard input.
2. **Immutable variable** — `val name` declares a read-only variable; its `String` type is inferred automatically.
3. **String templates** — `"Hello, $name!"` interpolates the value of `name` inside the string.

### Inicialización / Initialization

1. Crear la estructura de directorios:

   ```bash
   mkdir -p kotlin/core/foundations/hellouser
   ```

2. Escribir el archivo `HelloUser.kt` con el código fuente.

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

**ES:** El flujo del programa es:

1. Imprimir `"Enter your name: "` con `print()` (sin salto de línea).
2. Leer una línea desde `stdin` con `readln()`.
3. Imprimir `"Hello, $name!"` usando una plantilla de cadena.

**EN:** Program flow:

1. Print `"Enter your name: "` with `print()` (no newline).
2. Read a line from `stdin` with `readln()`.
3. Print `"Hello, $name!"` using a string template.

```kotlin
fun main() {
    print("Enter your name: ")
    val name = readln()
    println("Hello, $name!")
}
```

| Elemento | Propósito |
|----------|-----------|
| `print(...)` | Imprime en la salida estándar **sin** salto de línea al final (el cursor permanece junto al prompt). |
| `readln()` | Lee una línea completa desde la entrada estándar (incluye la espera a que el usuario presione Enter). |
| `val name` | Variable inmutable; Kotlin infiere que es de tipo `String`. |
| `"Hello, $name!"` | Plantilla de cadena: `$name` se sustituye por el valor de `name`. |
| `println(...)` | Imprime con salto de línea al final. |

> **ES:** `readln()` está disponible desde Kotlin 1.6 y reemplaza a `readLine()` (obsoleto). Devuelve la línea sin el salto de línea final.
> **EN:** `readln()` is available since Kotlin 1.6 and replaces `readLine()` (deprecated). It returns the line without the trailing newline.

> **ES:** En las plantillas de cadena, `$name` interpola una variable y `${expresión}` evalúa una expresión, por ejemplo `"${name.length}"`.
> **EN:** In string templates, `$name` interpolates a variable and `${expression}` evaluates an expression, e.g. `"${name.length}"`.

---

## 🚀 Compilación y ejecución / Build & Run

### Opción A — JAR ejecutable (recomendada) / Option A — Executable JAR (recommended)

```bash
cd kotlin/core/foundations/hellouser
kotlinc HelloUser.kt -include-runtime -d HelloUser.jar
java -jar HelloUser.jar
```

### Opción B — Compilar y ejecutar con el runner de Kotlin / Option B — Compile and run with the Kotlin runner

```bash
cd kotlin/core/foundations/hellouser
kotlinc HelloUser.kt
kotlin HelloUserKt.class
```

> **ES:** Con versiones recientes de Kotlin (2.x), el runner `kotlin` acepta directamente el archivo `.class` generado: `kotlin HelloUserKt.class`. En versiones anteriores se invoca el nombre de la clase sin extensión: `kotlin HelloUserKt`.
> **EN:** With recent Kotlin versions (2.x), the `kotlin` runner accepts the generated `.class` file directly: `kotlin HelloUserKt.class`. In older versions, the class name is invoked without the extension: `kotlin HelloUserKt`.

### Salida esperada / Expected output

```text
Enter your name: Ada
Hello, Ada!
```

> **ES:** El programa espera a que el usuario escriba su nombre y presione Enter antes de mostrar el saludo.

---

## 📝 Notas de implementación / Implementation Notes

- **ES:** Kotlin compila a bytecode JVM; el programa necesita una JVM para ejecutarse. La opción `-include-runtime` empaqueta el runtime de Kotlin dentro del JAR para que sea autocontenido.
- **EN:** Kotlin compiles to JVM bytecode; the program needs a JVM to run. The `-include-runtime` option bundles the Kotlin runtime inside the JAR so it is self-contained.
- **ES:** `val` declara valores inmutables (solo lectura); `var` se usa para variables mutables. Se prefiere `val` siempre que sea posible.
- **EN:** `val` declares immutable values (read-only); `var` is used for mutable variables. Prefer `val` whenever possible.
- **ES:** Al declarar `main` a nivel de archivo (sin clase), el compilador genera la clase `HelloUserKt`, cuyo nombre deriva del archivo `HelloUser.kt`.
- **EN:** By declaring `main` at file level (no class), the compiler generates the class `HelloUserKt`, whose name derives from the file `HelloUser.kt`.

---

## 🌐 Otras implementaciones / Other implementations

Este proyecto también está implementado en otros lenguajes. Explora el [repositorio principal](https://github.com/yorche3/programming_languages) para ver todas las versiones.

---

*🌐 [github.com/yorche3/programming_languages](https://github.com/yorche3/programming_languages) · [GitHub Pages](https://yorche3.github.io/programming_languages/)*
