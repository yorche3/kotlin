package data_structures_basics

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// Casos de prueba de la especificación 06_Data_Structures_Basics.md
//
// Los casos de cada estructura son pasos sucesivos sobre la misma instancia: se
// declara una instancia y se continúa con la fila siguiente sin reiniciar el
// escenario.
//
// Indicadores: solo el enlace de un `Node` es `null`; el resto de los fallos son
// valores devueltos (-1, false, 0), nunca excepciones.
private data class NamedCase(
    val name: String,
    val verify: () -> Unit,
)

// Ejecutor compartido: recorre los casos en orden sobre la misma instancia y
// nombra el caso que falla.
private fun runCases(subject: String, cases: List<NamedCase>) {
    cases.forEach { case ->
        withClue("$subject should satisfy ${case.name}") {
            case.verify()
        }
    }
}

class DataStructuresBasicsTest : StringSpec({

    "Node" {
        val firstNodeInput = 10
        val firstNodeValueOutput = 10
        val secondNodeInput = 20
        val linkedNodeValueOutput = 20
        val firstNode = Node(firstNodeInput)

        runCases(
            "Node",
            listOf(
                NamedCase("initialize and observe value/link") {
                    firstNode.value shouldBe firstNodeValueOutput
                    firstNode.next shouldBe null
                },
                NamedCase("initialize another node, link and traverse") {
                    val secondNode = Node(secondNodeInput)
                    firstNode.next = secondNode

                    firstNode.next?.value shouldBe linkedNodeValueOutput
                    secondNode.next shouldBe null
                },
            ),
        )
    }

    "LinkedList" {
        val failureOutput = -1
        val emptySizeOutput = 0
        val insertedSizeOutput = 4
        val insertedHeadOutput = 5
        val deletedSizeOutput = 3
        val deleteSuccessOutput = true
        val deleteFailureOutput = false
        val emptyOutput = true
        val list = LinkedList()

        runCases(
            "LinkedList",
            listOf(
                NamedCase("empty state") {
                    list.isEmpty shouldBe emptyOutput
                    list.size shouldBe emptySizeOutput
                    list.headValue shouldBe failureOutput
                },
                NamedCase("insert at both ends") {
                    list.insertTail(10)
                    list.insertTail(20)
                    list.insertHead(insertedHeadOutput)
                    list.insertTail(10)

                    list.size shouldBe insertedSizeOutput
                    list.headValue shouldBe insertedHeadOutput
                },
                NamedCase("delete first occurrence") {
                    list.delete(10) shouldBe deleteSuccessOutput
                    list.size shouldBe deletedSizeOutput
                    list.headValue shouldBe insertedHeadOutput
                },
                NamedCase("absent value") {
                    list.delete(99) shouldBe deleteFailureOutput
                    list.size shouldBe deletedSizeOutput
                    list.headValue shouldBe insertedHeadOutput
                },
                NamedCase("empty the list") {
                    list.delete(5) shouldBe deleteSuccessOutput
                    list.delete(20) shouldBe deleteSuccessOutput
                    list.delete(10) shouldBe deleteSuccessOutput

                    list.isEmpty shouldBe emptyOutput
                    list.size shouldBe emptySizeOutput
                    list.headValue shouldBe failureOutput
                },
            ),
        )
    }

    "Stack" {
        val failureOutput = -1
        val emptySizeOutput = 0
        val pushedSizeOutput = 3
        val topOutput = 30
        val popOutputs = listOf(30, 40, 20, 10)
        val stack = Stack()

        runCases(
            "Stack",
            listOf(
                NamedCase("empty state and failed removal") {
                    stack.isEmpty shouldBe true
                    stack.size shouldBe emptySizeOutput
                    stack.topValue shouldBe failureOutput
                    stack.pop() shouldBe failureOutput
                },
                NamedCase("LIFO and non-mutating peek") {
                    stack.push(10)
                    stack.push(20)
                    stack.push(topOutput)

                    stack.topValue shouldBe topOutput
                    stack.size shouldBe pushedSizeOutput
                },
                NamedCase("removal and reuse") {
                    stack.pop() shouldBe popOutputs[0]
                    stack.push(40)
                    stack.pop() shouldBe popOutputs[1]
                    stack.pop() shouldBe popOutputs[2]
                    stack.pop() shouldBe popOutputs[3]

                    stack.isEmpty shouldBe true
                    stack.size shouldBe emptySizeOutput
                },
                NamedCase("empty after removal") {
                    stack.pop() shouldBe failureOutput
                    stack.isEmpty shouldBe true
                },
            ),
        )
    }

    "Queue" {
        val failureOutput = -1
        val emptySizeOutput = 0
        val enqueuedSizeOutput = 3
        val frontOutput = 10
        val dequeueOutputs = listOf(10, 20, 30, 40)
        val queue = Queue()

        runCases(
            "Queue",
            listOf(
                NamedCase("empty state and failed removal") {
                    queue.isEmpty shouldBe true
                    queue.size shouldBe emptySizeOutput
                    queue.frontValue shouldBe failureOutput
                    queue.dequeue() shouldBe failureOutput
                },
                NamedCase("FIFO and non-mutating peek") {
                    queue.enqueue(frontOutput)
                    queue.enqueue(20)
                    queue.enqueue(30)

                    queue.frontValue shouldBe frontOutput
                    queue.size shouldBe enqueuedSizeOutput
                },
                NamedCase("removal and reuse") {
                    queue.dequeue() shouldBe dequeueOutputs[0]
                    queue.enqueue(40)
                    queue.dequeue() shouldBe dequeueOutputs[1]
                    queue.dequeue() shouldBe dequeueOutputs[2]
                    queue.dequeue() shouldBe dequeueOutputs[3]

                    queue.isEmpty shouldBe true
                    queue.size shouldBe emptySizeOutput
                },
                NamedCase("empty after removal") {
                    queue.dequeue() shouldBe failureOutput
                    queue.isEmpty shouldBe true
                },
            ),
        )
    }
})
