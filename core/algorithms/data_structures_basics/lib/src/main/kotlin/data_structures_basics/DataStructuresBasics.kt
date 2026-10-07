// data_structures_basics — celda enlazada compartida, lista, pila y cola.
//
// Especificación: 06_Data_Structures_Basics
//
// Contrato del paso 4b: tipos nuevos y firmas, con el cuerpo de cada operación en
// su indicador natural; el algoritmo es del paso 5 y la suite, del 4c.
//
// Indicadores: solo el enlace de un `Node` puede ser `null`; las operaciones que
// extraen un entero devuelven `Int` y su fallo es -1; las banderas devuelven
// `Boolean` y su fallo es `false`; los contadores devuelven `Int` y parten de 0.
//
// El `init` del contrato son los constructores: `Node(value)` y `LinkedList()`,
// `Stack()`, `Queue()` sin argumentos.

package data_structures_basics

/**
 * Celda enlazada compartida por [LinkedList], [Stack] y [Queue].
 *
 * El valor es inmutable tras la construcción; el enlace es mutable. `next` es el
 * único valor anulable del módulo.
 */
class Node(val value: Int) {
    var next: Node? = null
}

/**
 * Lista enlazada construida a mano sobre [Node].
 *
 * `LinkedList()` es el equivalente idiomático de `init()`: la lista vacía, con
 * cabeza y cola ausentes y contador a cero.
 */
class LinkedList {
    private var head: Node? = null
    private var tail: Node? = null
    private var count: Int = 0

    /** Valor de la cabeza, o -1 cuando la lista está vacía (`get_head`). */
    val headValue: Int
        get() = head?.value ?: -1

    /** Informa si la lista no tiene nodos (`is_empty`). */
    val isEmpty: Boolean
        get() = head == null

    /** Número de nodos de la lista (`size`). */
    val size: Int
        get() = count

    /** Inserta [value] al principio de la lista (`insert_head`). */
    fun insertHead(value: Int) {
        val newNode = Node(value)
        newNode.next = head
        head = newNode
        if (tail == null) {
            tail = newNode
        }
        count++
    }

    /** Inserta [value] al final de la lista (`insert_tail`). */
    fun insertTail(value: Int) {
        val newNode = Node(value)
        if (tail != null) {
            tail?.next = newNode
        }
        tail = newNode
        if (head == null) {
            head = newNode
        }
        count++
    }

    /** Elimina la primera aparición de [value] (`delete`): `false` cuando no está. */
    fun delete(value: Int): Boolean {
        var current = head
        var previous: Node? = null
        while (current != null) {
            if (current.value == value) {
                if (previous == null) {
                    head = current.next
                } else {
                    previous.next = current.next
                }
                if (current.next == null) {
                    tail = previous
                }
                count--
                return true
            }
            previous = current
            current = current.next
        }
        return false
    }
}

/**
 * Pila LIFO construida a mano sobre [Node].
 *
 * `Stack()` es el equivalente idiomático de `init()`.
 */
class Stack {
    private var top: Node? = null
    private var count: Int = 0

    /** Valor del tope, o -1 cuando la pila está vacía (`peek`). */
    val topValue: Int
        get() = top?.value ?: -1

    /** Informa si la pila no tiene nodos (`is_empty`). */
    val isEmpty: Boolean
        get() = top == null

    /** Número de nodos de la pila (`size`). */
    val size: Int
        get() = count

    /** Apila [value] sobre el tope (`push`). */
    fun push(value: Int) {
        val newNode = Node(value)
        newNode.next = top
        top = newNode
        count++
    }

    /** Extrae el tope, o -1 cuando la pila está vacía (`pop`). */
    fun pop(): Int {
        if (top == null) return -1
        val value = top!!.value
        top = top!!.next
        count--
        return value
    }
}

/**
 * Cola FIFO construida a mano sobre [Node].
 *
 * `Queue()` es el equivalente idiomático de `init()`.
 */
class Queue {
    private var front: Node? = null
    private var rear: Node? = null
    private var count: Int = 0

    /** Valor del frente, o -1 cuando la cola está vacía (`peek`). */
    val frontValue: Int
        get() = front?.value ?: -1

    /** Informa si la cola no tiene nodos (`is_empty`). */
    val isEmpty: Boolean
        get() = front == null

    /** Número de nodos de la cola (`size`). */
    val size: Int
        get() = count

    /** Añade [value] por el final de la cola (`enqueue`). */
    fun enqueue(value: Int) {
        val newNode = Node(value)
        if (rear != null) {
            rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
            front = newNode
        }
        count++
    }

    /** Extrae el frente, o -1 cuando la cola está vacía (`dequeue`). */
    fun dequeue(): Int {
        if (front == null) return -1
        val value = front!!.value
        front = front!!.next
        if (front == null) {
            rear = null
        }
        count--
        return value
    }
}
