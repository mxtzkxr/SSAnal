package calculation.utils.tree

import java.lang.StringBuilder

class BinaryTree(headValue: Double){
    private var _count: Int = 0
    private var _head: BinaryTreeNode? = null
    private var _current: BinaryTreeNode? = null
    val currentNode: BinaryTreeNode
        get() = _current!!
    val count: Int
        get() = _count
    init {
        _head = BinaryTreeNode(null, headValue)
        _current = _head
    }

    fun add(nodeValue: Double, isIncreased: Boolean){
        _current = _current!!.addNode(nodeValue, isIncreased)
        _count++
    }

    override fun toString() : String{
        val sb = StringBuilder()



        return sb.toString()
    }
}