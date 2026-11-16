package data_structures_advanced

abstract class Node(val value: Int)

class TreeNode(value: Int) : Node(value) {
    var left: TreeNode? = null
        get() = field
        set(value) {
            field = value
        }

    var right: TreeNode? = null
        get() = field
        set(value) {
            field = value
        }
}

class BinaryTree {
    private var root: TreeNode? = null
    private var count: Int = 0

    fun insert(value: Int): Boolean {
        if (root == null) {
            root = TreeNode(value)
            count += 1
            return true
        }
        var current = root
        while (true) {
            if (value == current!!.value) {
                return true
            }
            current = if (value < current.value) {
                if (current.left == null) {
                    current.left = TreeNode(value)
                    count += 1
                    return true
                }
                current.left
            } else {
                if (current.right == null) {
                    current.right = TreeNode(value)
                    count += 1
                    return true
                }
                current.right
            }
        }
    }

    fun contains(value: Int): Boolean {
        var current = root
        while (current != null) {
            if (value == current.value) {
                return true
            } else if (value < current.value) {
                current = current.left
            } else {
                current = current.right
            }
        }
        return false
    }

    val isEmpty: Boolean
        get() = count == 0

    val size: Int
        get() = count
}

internal class GraphNode(label: Int) : Node(label) {
    val neighbors: MutableList<Int> = mutableListOf()
    var nextVertex: GraphNode? = null
}

class Graph {
    private var vertices: GraphNode? = null
    private var vertexCount_: Int = 0
    private var edgeCount_: Int = 0

    private fun findVertex(label: Int): GraphNode? {
        var current = vertices
        while (current != null) {
            if (current.value == label) {
                return current
            }
            current = current.nextVertex
        }
        return null
    }

    fun addVertex(label: Int): Boolean {
        if (findVertex(label) != null) {
            return true
        }
        val newVertex = GraphNode(label)
        newVertex.nextVertex = vertices
        vertices = newVertex
        vertexCount_ += 1
        return true
    }

    private fun insertNeighbor(neighbors: MutableList<Int>, label: Int) {
        var index = 0
        while (index < neighbors.size && neighbors[index] < label) {
            index += 1
        }
        neighbors.add(index, label)
    }

    fun addEdge(u: Int, v: Int): Boolean {
        val vertexU = findVertex(u) ?: return false
        findVertex(v) ?: return false
        if (v in vertexU.neighbors) {
            return true
        }
        insertNeighbor(vertexU.neighbors, v)
        edgeCount_ += 1
        return true
    }

    fun hasEdge(u: Int, v: Int): Boolean {
        val vertexU = findVertex(u) ?: return false
        return v in vertexU.neighbors
    }

    fun getNeighbors(u: Int): List<Int>? {
        val vertexU = findVertex(u) ?: return null
        return vertexU.neighbors.toList()
    }

    val isEmpty: Boolean
        get() = vertexCount_ == 0

    val vertexCount: Int
        get() = vertexCount_

    val edgeCount: Int
        get() = edgeCount_
}
