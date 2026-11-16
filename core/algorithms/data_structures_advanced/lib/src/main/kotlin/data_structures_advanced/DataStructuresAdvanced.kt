package data_structures_advanced

abstract class Node(val value: Int)

@Suppress("UNUSED_PARAMETER")
class TreeNode(value: Int) : Node(value) {
    var left: TreeNode?
        get() = null
        set(value) {}

    var right: TreeNode?
        get() = null
        set(value) {}
}

@Suppress("UNUSED_PARAMETER")
class BinaryTree {
    fun insert(value: Int): Boolean = false

    fun contains(value: Int): Boolean = false

    val isEmpty: Boolean
        get() = false

    val size: Int
        get() = 0
}

internal class GraphNode(label: Int) : Node(label)

@Suppress("UNUSED_PARAMETER")
class Graph {
    fun addVertex(label: Int): Boolean = false

    fun addEdge(u: Int, v: Int): Boolean = false

    fun hasEdge(u: Int, v: Int): Boolean = false

    fun getNeighbors(u: Int): List<Int>? = null

    val isEmpty: Boolean
        get() = false

    val vertexCount: Int
        get() = 0

    val edgeCount: Int
        get() = 0
}
