package data_structures_basics

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DataStructuresBasicsBehaviorTest {

    private data class NamedCase(
        val name: String,
        val verify: () -> Unit,
    )

    private fun runCases(subject: String, cases: List<NamedCase>) {
        cases.forEach { case ->
            try {
                case.verify()
            } catch (error: AssertionError) {
                throw AssertionError("$subject should satisfy ${case.name}: ${error.message}", error)
            }
        }
    }

    @Test
    fun nodeOperations() {
        val firstNodeInput = 10
        val firstNodeValueOutput = 10
        val secondNodeInput = 20
        val linkedNodeValueOutput = 20
        val firstNode = Node(firstNodeInput)

        runCases(
            "Node",
            listOf(
                NamedCase("initialize and observe value/link") {
                    assertEquals(firstNodeValueOutput, firstNode.value)
                    assertNull(firstNode.next)
                },
                NamedCase("initialize another node, link and traverse") {
                    val secondNode = Node(secondNodeInput)
                    firstNode.next = secondNode

                    assertEquals(linkedNodeValueOutput, firstNode.next?.value)
                    assertNull(secondNode.next)
                },
            ),
        )
    }

    @Test
    fun linkedListOperations() {
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
                    assertTrue(list.isEmpty)
                    assertEquals(emptySizeOutput, list.size)
                    assertEquals(failureOutput, list.headValue)
                },
                NamedCase("insert at both ends") {
                    list.insertTail(10)
                    list.insertTail(20)
                    list.insertHead(insertedHeadOutput)
                    list.insertTail(10)

                    assertEquals(insertedSizeOutput, list.size)
                    assertEquals(insertedHeadOutput, list.headValue)
                },
                NamedCase("delete first occurrence") {
                    assertEquals(deleteSuccessOutput, list.delete(10))
                    assertEquals(deletedSizeOutput, list.size)
                    assertEquals(insertedHeadOutput, list.headValue)
                },
                NamedCase("absent value") {
                    assertEquals(deleteFailureOutput, list.delete(99))
                    assertEquals(deletedSizeOutput, list.size)
                    assertEquals(insertedHeadOutput, list.headValue)
                },
                NamedCase("empty the list") {
                    assertTrue(list.delete(5))
                    assertTrue(list.delete(20))
                    assertTrue(list.delete(10))

                    assertTrue(list.isEmpty)
                    assertEquals(emptySizeOutput, list.size)
                    assertEquals(failureOutput, list.headValue)
                },
            ),
        )
    }

    @Test
    fun stackOperations() {
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
                    assertTrue(stack.isEmpty)
                    assertEquals(emptySizeOutput, stack.size)
                    assertEquals(failureOutput, stack.topValue)
                    assertEquals(failureOutput, stack.pop())
                },
                NamedCase("LIFO and non-mutating peek") {
                    stack.push(10)
                    stack.push(20)
                    stack.push(topOutput)

                    assertEquals(topOutput, stack.topValue)
                    assertEquals(pushedSizeOutput, stack.size)
                },
                NamedCase("removal and reuse") {
                    assertEquals(popOutputs[0], stack.pop())
                    stack.push(40)
                    assertEquals(popOutputs[1], stack.pop())
                    assertEquals(popOutputs[2], stack.pop())
                    assertEquals(popOutputs[3], stack.pop())

                    assertTrue(stack.isEmpty)
                    assertEquals(emptySizeOutput, stack.size)
                },
                NamedCase("empty after removal") {
                    assertEquals(failureOutput, stack.pop())
                    assertTrue(stack.isEmpty)
                },
            ),
        )
    }

    @Test
    fun queueOperations() {
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
                    assertTrue(queue.isEmpty)
                    assertEquals(emptySizeOutput, queue.size)
                    assertEquals(failureOutput, queue.frontValue)
                    assertEquals(failureOutput, queue.dequeue())
                },
                NamedCase("FIFO and non-mutating peek") {
                    queue.enqueue(frontOutput)
                    queue.enqueue(20)
                    queue.enqueue(30)

                    assertEquals(frontOutput, queue.frontValue)
                    assertEquals(enqueuedSizeOutput, queue.size)
                },
                NamedCase("removal and reuse") {
                    assertEquals(dequeueOutputs[0], queue.dequeue())
                    queue.enqueue(40)
                    assertEquals(dequeueOutputs[1], queue.dequeue())
                    assertEquals(dequeueOutputs[2], queue.dequeue())
                    assertEquals(dequeueOutputs[3], queue.dequeue())

                    assertTrue(queue.isEmpty)
                    assertEquals(emptySizeOutput, queue.size)
                },
                NamedCase("empty after removal") {
                    assertEquals(failureOutput, queue.dequeue())
                    assertTrue(queue.isEmpty)
                },
            ),
        )
    }
}
