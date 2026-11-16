package data_structures_advanced

import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// Casos de prueba de la especificación 07_Data_Structures_Advanced.md
//
// Cada fila de la especificación es un test con una instancia recién creada;
// los pasos de cada fila se ejecutan en orden y se identifican por nombre.
//
// Indicadores: ausencia de enlace y fallo de `getNeighbors` son `null`; el
// fallo de `contains`, `hasEdge`, `addEdge` es `false`. Los vecinos vacíos
// (`emptyList()`) se distinguen del fallo (`null`).
//
// Adaptaciones: `TreeNode` es mutable, así que el caso "Adaptación inmutable"
// no aplica. `Graph.getNeighbors` devuelve `List<Int>`: el caso de aislamiento
// intenta mutar una copia devuelta y tolera que sea inmutable.

// Ejecutor compartido: nombra el paso que falla.
private fun step(subject: String, name: String, verify: () -> Unit) {
    withClue("$subject should satisfy $name") {
        verify()
    }
}

private fun graphOf(vararg labels: Int): Graph {
    val graph = Graph()
    labels.forEach { graph.addVertex(it) }
    return graph
}

private fun treeOf(vararg values: Int): Pair<BinaryTree, List<Boolean>> {
    val tree = BinaryTree()
    val results = values.map { tree.insert(it) }
    return tree to results
}

class DataStructuresAdvancedTest : StringSpec({

    // ---- TreeNode ----

    "TreeNode: create a tree node" {
        val valueInput = 10
        val valueOutput = 10
        val node = TreeNode(valueInput)

        step("TreeNode", "create a tree node") {
            node.value shouldBe valueOutput
        }
    }

    "TreeNode: absent initial links" {
        val node = TreeNode(10)

        step("TreeNode", "absent initial links") {
            node.left shouldBe null
            node.right shouldBe null
        }
    }

    "TreeNode: link two children" {
        val leftValueOutput = 20
        val rightValueOutput = 30
        val parent = TreeNode(10)
        parent.left = TreeNode(20)
        parent.right = TreeNode(30)

        step("TreeNode", "link two children") {
            parent.left?.value shouldBe leftValueOutput
            parent.right?.value shouldBe rightValueOutput
        }
    }

    "TreeNode: traverse each link" {
        val leftValueOutput = 20
        val rightValueOutput = 30
        val parent = TreeNode(10)
        parent.left = TreeNode(20)
        parent.right = TreeNode(30)

        step("TreeNode", "traverse each link: children values") {
            parent.left?.value shouldBe leftValueOutput
            parent.right?.value shouldBe rightValueOutput
        }
        step("TreeNode", "traverse each link: children links absent") {
            parent.left?.left shouldBe null
            parent.left?.right shouldBe null
            parent.right?.left shouldBe null
            parent.right?.right shouldBe null
        }
    }

    "TreeNode: unlink children" {
        val parentValueOutput = 10
        val rightValueOutput = 30
        val parent = TreeNode(10)
        val leftChild = TreeNode(20)
        val rightChild = TreeNode(30)
        parent.left = leftChild
        parent.right = rightChild

        parent.left = null
        step("TreeNode", "unlink children: clear left") {
            parent.value shouldBe parentValueOutput
            parent.left shouldBe null
            parent.right?.value shouldBe rightValueOutput
        }

        parent.right = null
        step("TreeNode", "unlink children: clear right") {
            parent.value shouldBe parentValueOutput
            parent.left shouldBe null
            parent.right shouldBe null
        }
    }

    // ---- BinaryTree ----

    "BinaryTree: create empty" {
        val tree = BinaryTree()

        step("BinaryTree", "create empty") {
            tree.isEmpty shouldBe true
            tree.size shouldBe 0
            tree.contains(50) shouldBe false
        }
    }

    "BinaryTree: insert the root" {
        val (tree, inserts) = treeOf(50)

        step("BinaryTree", "insert the root") {
            inserts shouldBe listOf(true)
            tree.size shouldBe 1
            tree.isEmpty shouldBe false
            tree.contains(50) shouldBe true
        }
    }

    "BinaryTree: insert lower and higher" {
        val (tree, inserts) = treeOf(50, 30, 70)

        step("BinaryTree", "insert lower and higher") {
            inserts shouldBe listOf(true, true, true)
            tree.size shouldBe 3
            listOf(50, 30, 70).forEach { tree.contains(it) shouldBe true }
        }
    }

    "BinaryTree: multilevel branches" {
        val values = intArrayOf(50, 30, 70, 20, 40)
        val (tree, inserts) = treeOf(*values)

        step("BinaryTree", "multilevel branches") {
            inserts shouldBe List(5) { true }
            values.forEach { tree.contains(it) shouldBe true }
            tree.size shouldBe 5
        }
    }

    "BinaryTree: missing value in nonempty tree" {
        val (tree, _) = treeOf(50)

        step("BinaryTree", "missing value in nonempty tree") {
            tree.contains(99) shouldBe false
            tree.size shouldBe 1
            tree.contains(50) shouldBe true
        }
    }

    "BinaryTree: idempotent duplicate" {
        val (tree, inserts) = treeOf(50, 30, 70, 30)

        step("BinaryTree", "idempotent duplicate") {
            inserts shouldBe List(4) { true }
            tree.size shouldBe 3
            listOf(50, 30, 70).forEach { tree.contains(it) shouldBe true }
        }
    }

    "BinaryTree: ordered insertions" {
        val values = intArrayOf(20, 30, 40, 50, 70)
        val (tree, inserts) = treeOf(*values)

        step("BinaryTree", "ordered insertions") {
            inserts shouldBe List(5) { true }
            tree.size shouldBe 5
            values.forEach { tree.contains(it) shouldBe true }
            tree.contains(99) shouldBe false
        }
    }

    // ---- Graph ----

    "Graph: create empty" {
        val graph = Graph()

        step("Graph", "create empty") {
            graph.isEmpty shouldBe true
            graph.vertexCount shouldBe 0
            graph.edgeCount shouldBe 0
            graph.hasEdge(10, 30) shouldBe false
            graph.getNeighbors(10) shouldBe null
        }
    }

    "Graph: isolated vertex" {
        val graph = Graph()

        step("Graph", "isolated vertex: add") {
            graph.addVertex(10) shouldBe true
            graph.isEmpty shouldBe false
            graph.vertexCount shouldBe 1
            graph.edgeCount shouldBe 0
            graph.getNeighbors(10) shouldBe emptyList()
        }
    }

    "Graph: nonconsecutive labels and directed edge" {
        val graph = graphOf(10, 70)

        step("Graph", "nonconsecutive labels and directed edge") {
            graph.addEdge(10, 70) shouldBe true
            graph.hasEdge(10, 70) shouldBe true
            graph.hasEdge(70, 10) shouldBe false
            graph.vertexCount shouldBe 2
            graph.edgeCount shouldBe 1
        }
    }

    "Graph: duplicate vertex preserves adjacency" {
        val graph = graphOf(10, 30)

        step("Graph", "duplicate vertex preserves adjacency") {
            graph.addEdge(10, 30) shouldBe true
            graph.addVertex(10) shouldBe true
            graph.vertexCount shouldBe 2
            graph.edgeCount shouldBe 1
            graph.getNeighbors(10) shouldBe listOf(30)
        }
    }

    "Graph: duplicate edge" {
        val graph = graphOf(10, 30)

        step("Graph", "duplicate edge") {
            graph.addEdge(10, 30) shouldBe true
            graph.addEdge(10, 30) shouldBe true
            graph.vertexCount shouldBe 2
            graph.edgeCount shouldBe 1
            graph.getNeighbors(10) shouldBe listOf(30)
        }
    }

    "Graph: missing endpoint without mutation" {
        val graph = graphOf(10, 30)
        graph.addEdge(10, 30)

        step("Graph", "missing endpoint without mutation: failures") {
            graph.addEdge(10, 99) shouldBe false
            graph.addEdge(99, 10) shouldBe false
            graph.addEdge(98, 99) shouldBe false
            graph.addEdge(99, 99) shouldBe false
        }
        step("Graph", "missing endpoint without mutation: state preserved") {
            graph.vertexCount shouldBe 2
            graph.edgeCount shouldBe 1
            graph.getNeighbors(10) shouldBe listOf(30)
            graph.getNeighbors(30) shouldBe emptyList()
            graph.hasEdge(10, 99) shouldBe false
            graph.hasEdge(99, 10) shouldBe false
            graph.hasEdge(98, 99) shouldBe false
            graph.hasEdge(99, 99) shouldBe false
            graph.getNeighbors(98) shouldBe null
            graph.getNeighbors(99) shouldBe null
        }
    }

    "Graph: sorted neighbours and counts" {
        val graph = graphOf(10, 30, 50, 70)
        val edgeInputs = listOf(10 to 70, 10 to 30, 10 to 50, 30 to 50)

        step("Graph", "sorted neighbours and counts") {
            edgeInputs.map { (u, v) -> graph.addEdge(u, v) } shouldBe List(4) { true }
            graph.getNeighbors(10) shouldBe listOf(30, 50, 70)
            graph.getNeighbors(30) shouldBe listOf(50)
            graph.getNeighbors(50) shouldBe emptyList()
            graph.getNeighbors(70) shouldBe emptyList()
            graph.vertexCount shouldBe 4
            graph.edgeCount shouldBe 4
        }
    }

    "Graph: missing-edge query" {
        val graph = graphOf(10, 30)

        step("Graph", "missing-edge query") {
            graph.hasEdge(10, 30) shouldBe false
            graph.vertexCount shouldBe 2
            graph.edgeCount shouldBe 0
            graph.isEmpty shouldBe false
        }
    }

    "Graph: neighbours of missing vertex" {
        val graph = graphOf(10)

        step("Graph", "neighbours of missing vertex") {
            graph.getNeighbors(99) shouldBe null
            graph.getNeighbors(10) shouldBe emptyList()
            graph.vertexCount shouldBe 1
            graph.edgeCount shouldBe 0
        }
    }

    "Graph: self-loop and duplicate" {
        val graph = graphOf(10)

        step("Graph", "self-loop and duplicate") {
            graph.addEdge(10, 10) shouldBe true
            graph.addEdge(10, 10) shouldBe true
            graph.hasEdge(10, 10) shouldBe true
            graph.getNeighbors(10) shouldBe listOf(10)
            graph.vertexCount shouldBe 1
            graph.edgeCount shouldBe 1
        }
    }

    "Graph: neighbour-result isolation" {
        val graph = graphOf(10, 30, 50)
        graph.addEdge(10, 30)
        val savedNeighbors = graph.getNeighbors(10)

        step("Graph", "neighbour-result isolation: copy change") {
            @Suppress("UNCHECKED_CAST")
            val otherCopy = graph.getNeighbors(10) as? MutableList<Int>
            runCatching { otherCopy?.add(99) }
            graph.getNeighbors(10) shouldBe listOf(30)
        }
        step("Graph", "neighbour-result isolation: later insertion") {
            graph.addEdge(10, 50) shouldBe true
            savedNeighbors shouldBe listOf(30)
            graph.getNeighbors(10) shouldBe listOf(30, 50)
            graph.vertexCount shouldBe 3
            graph.edgeCount shouldBe 2
        }
    }
})
