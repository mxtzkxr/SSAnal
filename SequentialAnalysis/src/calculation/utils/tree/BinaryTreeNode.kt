package calculation.utils.tree

class BinaryTreeNode (private val parent: BinaryTreeNode?, val nodeValue: Double){
    private var increase: BinaryTreeNode? = null
    private var reduction: BinaryTreeNode? = null

    fun addNode(inputValue: Double, isIncreased: Boolean) : BinaryTreeNode{
        if(isIncreased){
            increase = BinaryTreeNode(this, inputValue)
            return increase!!
        }else{
            reduction = BinaryTreeNode(this, inputValue)
            return  reduction!!
        }
    }
}