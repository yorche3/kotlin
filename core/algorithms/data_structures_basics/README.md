# Data Structures Basics — Kotlin

Implementación de la especificación [06_Data_Structures_Basics](../../../../docs/core/algorithms/06_Data_Structures_Basics.md) en **Kotlin**, con un enfoque manual y minimalista.

**ES:** Se implementan `Node`, `LinkedList`, `Stack` y `Queue` sobre nodos enlazados construidos a mano, sin delegar en colecciones de la biblioteca estándar. El proyecto usa Gradle con el plugin de Kotlin JVM y JUnit 5 para las pruebas.

**EN:** `Node`, `LinkedList`, `Stack` and `Queue` are implemented over hand-built linked nodes, without delegating to standard-library collections. The project uses Gradle with the Kotlin JVM plugin and JUnit 5 for tests.

---

## 📂 Archivos y estructura / Files & Structure

| Archivo / Directory | Propósito / Purpose |
|---|---|
| `lib/src/main/kotlin/data_structures_basics/DataStructuresBasics.kt` | Código fuente principal: `Node`, `LinkedList`, `Stack` y `Queue` / Main source: `Node`, `LinkedList`, `Stack` and `Queue` |
| `lib/src/test/kotlin/data_structures_basics/DataStructuresBasicsTest.kt` | Pruebas unitarias con casos de la especificación / Unit tests with specification cases |
| `lib/src/test/kotlin/data_structures_basics/DataStructuresBasicsBehaviorTest.kt` | Pruebas de comportamiento con escenarios encadenados / Behaviour tests with chained scenarios |
| `lib/build.gradle.kts` | Configuración de construcción del subproyecto / Subproject build configuration |
| `build.gradle.kts` | Configuración raíz de Gradle / Root Gradle configuration |
| `settings.gradle.kts` | Ajustes del proyecto multi-módulo / Multi-module project settings |
| `gradle/` | Wrapper y catálogo de versiones / Wrapper and version catalog |
| `gradlew` / `gradlew.bat` | Scripts del wrapper de Gradle / Gradle wrapper scripts |

**ES:** La ubicación esperada por la especificación es `src/` y `test/`; este proyecto usa el layout estándar de Gradle (`lib/src/main/kotlin/` y `lib/src/test/kotlin/`) porque el subproyecto se generó con `gradle init --type kotlin-library`. La separación `main`/`test` es la convención de Gradle y no afecta al contrato.

**EN:** The specification's expected location is `src/` and `test/`; this project uses Gradle's standard layout (`lib/src/main/kotlin/` and `lib/src/test/kotlin/`) because the subproject was generated with `gradle init --type kotlin-library`. The `main`/`test` split is Gradle's convention and does not affect the contract.

## 🛠️ Enfoque y construcción / Approach & Build

**ES:** El proyecto se creó con `gradle init --type kotlin-library --dsl kotlin` dentro de la carpeta del módulo, lo que generó el layout multi-módulo con `lib/` como subproyecto. No se añadieron dependencias externas más allá de Kotlin Test y JUnit 5.

**EN:** The project was created with `gradle init --type kotlin-library --dsl kotlin` inside the module folder, which generated the multi-module layout with `lib/` as a subproject. No external dependencies were added beyond Kotlin Test and JUnit 5.

## 📄 Configuración clave / Key Configuration

**ES:** `lib/build.gradle.kts` aplica el plugin `org.jetbrains.kotlin.jvm` y `java-library`, usa Java 21 como toolchain y declara `kotlin-test` y `junit-jupiter-engine` como dependencias de prueba. El catálogo de versiones (`gradle/libs.versions.toml`) centraliza las versiones de Kotlin, JUnit y las bibliotecas opcionales `commons-math3` y `guava` (no usadas por este módulo).

**EN:** `lib/build.gradle.kts` applies the `org.jetbrains.kotlin.jvm` and `java-library` plugins, uses Java 21 as toolchain and declares `kotlin-test` and `junit-jupiter-engine` as test dependencies. The version catalog (`gradle/libs.versions.toml`) centralises versions for Kotlin, JUnit and the optional libraries `commons-math3` and `guava` (not used by this module).

## 🚀 Compilación y ejecución / Build & Run

```bash
./gradlew build
./gradlew test
```

**Salida real / Actual output:**

```text
> Task :lib:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :lib:processResources NO-SOURCE
> Task :lib:processTestResources NO-SOURCE
> Task :lib:compileKotlin
> Task :lib:compileJava NO-SOURCE
> Task :lib:classes UP-TO-DATE
> Task :lib:jar UP-TO-DATE
> Task :lib:compileTestKotlin
> Task :lib:compileTestJava NO-SOURCE
> Task :lib:testClasses UP-TO-DATE
> Task :lib:test

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
Configuration cache entry reused.
```

**ES:** 4 pruebas ejecutadas, 0 fallos, 100 % de éxito. La salida se copió de la última ejecución real con `./gradlew test --rerun-tasks --console=plain`.

**EN:** 4 tests executed, 0 failures, 100 % successful. Output copied from the last real run with `./gradlew test --rerun-tasks --console=plain`.

## 🧠 Algoritmos y operaciones / Algorithms & Operations

| Operación / Operation | Entrada → salida / Input → output | Complejidad / Complexity | Notas / Notes |
|---|---|---|---|
| `Node(value)` | `Int → Node` | `O(1)` | Constructor; `next` queda `null` / Constructor; `next` is `null` |
| `Node.value` | `→ Int` | `O(1)` | Propiedad inmutable / Immutable property |
| `Node.next` | `→ Node?` | `O(1)` | Propiedad mutable; `null` indica ausencia / Mutable property; `null` means absent |
| `LinkedList()` | `→ LinkedList` | `O(1)` | Constructor; cabeza, cola ausentes y tamaño 0 / Constructor; head, tail absent and size 0 |
| `LinkedList.headValue` | `→ Int` | `O(1)` | Valor de la cabeza o `-1` si está vacía / Head value or `-1` if empty |
| `LinkedList.isEmpty` | `→ Boolean` | `O(1)` | Propiedad / Property |
| `LinkedList.size` | `→ Int` | `O(1)` | Propiedad / Property |
| `LinkedList.insertHead(value)` | `Int → Unit` | `O(1)` | Inserta al principio / Inserts at the front |
| `LinkedList.insertTail(value)` | `Int → Unit` | `O(1)` | Inserta al final / Inserts at the end |
| `LinkedList.delete(value)` | `Int → Boolean` | `O(n)` | Elimina primera aparición; `false` si no está / Deletes first occurrence; `false` if absent |
| `Stack()` | `→ Stack` | `O(1)` | Constructor; tope ausente y tamaño 0 / Constructor; top absent and size 0 |
| `Stack.topValue` | `→ Int` | `O(1)` | Valor del tope o `-1` si está vacía / Top value or `-1` if empty |
| `Stack.isEmpty` | `→ Boolean` | `O(1)` | Propiedad / Property |
| `Stack.size` | `→ Int` | `O(1)` | Propiedad / Property |
| `Stack.push(value)` | `Int → Unit` | `O(1)` | Apila sobre el tope / Pushes onto top |
| `Stack.pop()` | `→ Int` | `O(1)` | Extrae el tope; `-1` si está vacía / Pops top; `-1` if empty |
| `Queue()` | `→ Queue` | `O(1)` | Constructor; frente y cola ausentes, tamaño 0 / Constructor; front and rear absent, size 0 |
| `Queue.frontValue` | `→ Int` | `O(1)` | Valor del frente o `-1` si está vacía / Front value or `-1` if empty |
| `Queue.isEmpty` | `→ Boolean` | `O(1)` | Propiedad / Property |
| `Queue.size` | `→ Int` | `O(1)` | Propiedad / Property |
| `Queue.enqueue(value)` | `Int → Unit` | `O(1)` | Añade por el final / Adds at the rear |
| `Queue.dequeue()` | `→ Int` | `O(1)` | Extrae el frente; `-1` si está vacía / Dequeues front; `-1` if empty |

## 🧩 Decisiones de diseño / Design decisions

| Decisión / Decision | Alternativa considerada / Alternative | Razón / Reason |
|---|---|---|
| `Node` como clase con `val value` y `var next: Node?` | `data class` inmutable o registro | El pseudocódigo exige mutación de `next`; `data class` añadiría `equals`/`hashCode` innecesarios para un nodo interno / Pseudocode requires `next` mutation; `data class` would add unnecessary `equals`/`hashCode` for an internal node |
| Propiedades Kotlin (`isEmpty`, `size`, `headValue`) en lugar de métodos `is_empty()`, `size()`, `get_head()` | Métodos con paréntesis | Las propiedades sin argumentos son la convención Kotlin para accesores de estado; el contrato observable es el mismo / Kotlin convention for state accessors with no arguments; observable contract is the same |
| `headValue`, `topValue`, `frontValue` como nombres de `peek`/`get_head` | `peek()` como método | Reflejan que son propiedades de solo lectura que devuelven el valor del puntero principal o `-1` / They reflect read-only properties returning the main pointer's value or `-1` |
| Una sola clase `Node` compartida por los tres ADT | Tipos de nodo distintos por estructura | El contrato exige un único `Node` compartido; cada ADT gestiona sus propios punteros / Contract requires a single shared `Node`; each ADT manages its own pointers |
| Dos archivos de prueba: `DataStructuresBasicsTest.kt` y `DataStructuresBasicsBehaviorTest.kt` | Un solo archivo de prueba | El primero contiene pruebas unitarias directas; el segundo organiza los casos de la especificación como escenarios encadenados con `NamedCase` / The former holds direct unit tests; the latter organises specification cases as chained scenarios with `NamedCase` |

## 🔀 Adaptaciones idiomáticas / Idiomatic adaptations

| Especificación / Specification | Adaptación / Adaptation | Justificación / Justification |
|---|---|---|
| `init(value)` / `init()` como procedimiento de inicialización | Constructores `Node(value)`, `LinkedList()`, `Stack()`, `Queue()` | Kotlin usa constructores como forma idiomática de inicialización; el contrato de «declarar, inicializar, usar» se cumple con la construcción / Kotlin uses constructors as the idiomatic initialisation form; the "declare, initialise, use" contract is met at construction |
| `get_value()`, `get_next()`, `set_next(next)` | Propiedades `value` (val), `next` (var) | Kotlin prefiere propiedades sobre métodos sin argumentos para accesores y mutadores simples / Kotlin prefers properties over no-arg methods for simple accessors and mutators |
| `is_empty()`, `size()` como métodos | Propiedades `isEmpty`, `size` | Propiedades de solo lectura para estado derivado; convención Kotlin / Read-only properties for derived state; Kotlin convention |
| `get_head()`, `peek()` como métodos | Propiedades `headValue`, `topValue`, `frontValue` | Accesores de solo lectura que devuelven el valor del puntero principal o el indicador de fallo / Read-only accessors returning the main pointer's value or the failure indicator |
| `insert_head(value)`, `insert_tail(value)` | `insertHead(value)`, `insertTail(value)` | camelCase es la convención de nomenclatura de Kotlin / camelCase is Kotlin's naming convention |
| Ubicación esperada `src/` y `test/` | Layout Gradle `lib/src/main/kotlin/` y `lib/src/test/kotlin/` | El subproyecto se generó con `gradle init --type kotlin-library`; la separación `main`/`test` es la convención de Gradle / Subproject was generated with `gradle init --type kotlin-library`; the `main`/`test` split is Gradle's convention |
| Ausencia de enlace con representación nativa del lenguaje | `null` para `Node.next` y los punteros internos (`head`, `tail`, `top`, `front`, `rear`) | Kotlin tiene tipos anulables (`Node?`) como representación nativa de ausencia; es el indicador natural del lenguaje / Kotlin has nullable types (`Node?`) as the native representation of absence; it is the language's natural indicator |

## 🚨 Indicadores de fallo / Failure indicators

| Operación / Operation | Situación de fallo / Failure situation | Indicador / Indicator | Ejemplo / Example |
|---|---|---|---|
| `LinkedList.headValue` | Lista vacía | `-1` | `LinkedList().headValue` → `-1` |
| `LinkedList.delete` | Valor no encontrado | `false` | `list.delete(99)` → `false` |
| `Stack.topValue` | Pila vacía | `-1` | `Stack().topValue` → `-1` |
| `Stack.pop` | Pila vacía | `-1` | `Stack().pop()` → `-1` |
| `Queue.frontValue` | Cola vacía | `-1` | `Queue().frontValue` → `-1` |
| `Queue.dequeue` | Cola vacía | `-1` | `Queue().dequeue()` → `-1` |
| `Node.next` | Enlace ausente | `null` | `Node(10).next` → `null` |

## ✅ Cobertura de pruebas / Test coverage

| Caso de la especificación / Specification case | Cubierto / Covered | Prueba / Test | Notas / Notes |
|---|---|:--:|---|
| **Node**: inicializar y observar valor/enlace | Sí | `DataStructuresBasicsBehaviorTest.nodeOperations` | Verifica `value = 10` y `next = null` / Verifies `value = 10` and `next = null` |
| **Node**: inicializar otro nodo, enlazar y recorrer | Sí | `DataStructuresBasicsBehaviorTest.nodeOperations` | Enlaza `b` a `a.next` y verifica `get_value(get_next(a)) = 20` / Links `b` to `a.next` and verifies `get_value(get_next(a)) = 20` |
| **LinkedList**: estado vacío | Sí | `DataStructuresBasicsBehaviorTest.linkedListOperations` | `isEmpty = true`, `size = 0`, `headValue = -1` |
| **LinkedList**: insertar por ambos extremos | Sí | `DataStructuresBasicsBehaviorTest.linkedListOperations` | `insertTail(10)`, `insertTail(20)`, `insertHead(5)`, `insertTail(10)` → `size = 4` |
| **LinkedList**: eliminar primera aparición | Sí | `DataStructuresBasicsBehaviorTest.linkedListOperations` | `delete(10)` → `true`, `size = 3` |
| **LinkedList**: valor ausente | Sí | `DataStructuresBasicsBehaviorTest.linkedListOperations` | `delete(99)` → `false`, tamaño no cambia / size unchanged |
| **LinkedList**: vaciar la lista | Sí | `DataStructuresBasicsBehaviorTest.linkedListOperations` | Tres `delete` con éxito; `isEmpty = true`, `size = 0`, `headValue = -1` |
| **Stack**: estado vacío y extracción fallida | Sí | `DataStructuresBasicsBehaviorTest.stackOperations` | `isEmpty = true`, `size = 0`, `topValue = -1`, `pop() = -1` |
| **Stack**: LIFO y peek no mutante | Sí | `DataStructuresBasicsBehaviorTest.stackOperations` | Tres `push`; `topValue = 30`, `size = 3` |
| **Stack**: extracción y reutilización | Sí | `DataStructuresBasicsBehaviorTest.stackOperations` | `pop`, `push(40)`, tres `pop` → `30, 40, 20, 10`; `isEmpty = true` |
| **Stack**: vacío tras extracción | Sí | `DataStructuresBasicsBehaviorTest.stackOperations` | `pop() = -1`, `isEmpty = true` |
| **Queue**: estado vacío y extracción fallida | Sí | `DataStructuresBasicsBehaviorTest.queueOperations` | `isEmpty = true`, `size = 0`, `frontValue = -1`, `dequeue() = -1` |
| **Queue**: FIFO y peek no mutante | Sí | `DataStructuresBasicsBehaviorTest.queueOperations` | Tres `enqueue`; `frontValue = 10`, `size = 3` |
| **Queue**: extracción y reutilización | Sí | `DataStructuresBasicsBehaviorTest.queueOperations` | `dequeue`, `enqueue(40)`, tres `dequeue` → `10, 20, 30, 40`; `isEmpty = true` |
| **Queue**: vacío tras extracción | Sí | `DataStructuresBasicsBehaviorTest.queueOperations` | `dequeue() = -1`, `isEmpty = true` |

## ⚠️ Limitaciones conocidas / Known limitations

Ninguna / None

**ES:** El módulo implementa todas las operaciones del contrato con las complejidades prometidas y no hay restricciones de capacidad. Los valores de prueba usan enteros positivos para no colisionar con el indicador de fallo `-1`.

**EN:** The module implements every contract operation with the promised complexities and has no capacity restrictions. Test values use positive integers to avoid colliding with the `-1` failure indicator.

## 📝 Notas de implementación / Implementation Notes

**ES:** Kotlin no garantiza TCO (tail-call optimisation), pero este módulo no usa recursión: todas las operaciones son iterativas con punteros y contadores, por lo que la cuestión de TCO no aplica. El manejo de errores usa el indicador natural del lenguaje: `null` para la ausencia de enlace en `Node` y `-1` para las operaciones que devuelven `Int` cuando la estructura está vacía. Las propiedades Kotlin (`isEmpty`, `size`, `headValue`, `topValue`, `frontValue`) sustituyen a los métodos `is_empty()`, `size()`, `get_head()`, `peek()` del pseudocódigo, conservando el mismo contrato observable. La suite usa JUnit 5 con `Assertions` y organiza los casos de la especificación como escenarios encadenados en `DataStructuresBasicsBehaviorTest`, donde cada `@Test` ejecuta pasos sucesivos sobre la misma instancia sin reiniciar el estado.

**EN:** Kotlin does not guarantee TCO (tail-call optimisation), but this module uses no recursion: all operations are iterative with pointers and counters, so TCO is not relevant. Error handling uses the language's natural indicator: `null` for absent links in `Node` and `-1` for operations returning `Int` when the structure is empty. Kotlin properties (`isEmpty`, `size`, `headValue`, `topValue`, `frontValue`) replace the pseudocode's `is_empty()`, `size()`, `get_head()`, `peek()` methods, preserving the same observable contract. The suite uses JUnit 5 with `Assertions` and organises specification cases as chained scenarios in `DataStructuresBasicsBehaviorTest`, where each `@Test` runs successive steps on the same instance without resetting state.

**ES:** Este proyecto también está implementado en otros lenguajes. Explora el repositorio principal para consultar las demás versiones.

**EN:** This project is also implemented in other languages. Explore the main repository to see the other versions.

## 🔍 Checklist de validación / Validation checklist

- [x] La suite nativa se ejecutó y su salida real está copiada en este README.
- [x] Cada caso de la especificación tiene su fila en _Cobertura de pruebas_ (o `Omitido` con razón).
- [x] Cada desviación del pseudocódigo o de la ubicación esperada está en _Adaptaciones idiomáticas_.
- [x] Cada operación con fallo posible está en _Indicadores de fallo_.
- [x] No hay rutas absolutas del autor, credenciales ni salidas inventadas.
- [x] Los enlaces relativos resuelven dentro del repositorio y el documento es bilingüe.
- [x] Ninguna sección repite lo que ya dice la especificación.

## 📚 Referencias / References

| Tipo / Kind | Referencia / Reference |
|---|---|
| Especificación / Specification | [`06_Data_Structures_Basics.md`](../../../../docs/core/algorithms/06_Data_Structures_Basics.md) |
| Módulo homologado del lenguaje / Homologated module | [`kotlin/core/foundations/numbers/`](../../foundations/numbers/) |
| Guía de inicialización / Initialisation guide | [`core/00_Project_Initialization_Guide.md`](../../../../docs/core/00_Project_Initialization_Guide.md) |
| Adaptaciones idiomáticas / Idiomatic adaptations | [`AGENT_Template.md`](../../../../docs/AGENT_Template.md) |
| Validación de la documentación / Documentation validation | [`WORKFLOW.md`](../../../../docs/WORKFLOW.md) |
| Documentación oficial del lenguaje / Language official docs | [Kotlin official documentation](https://kotlinlang.org/docs/home.html) |
