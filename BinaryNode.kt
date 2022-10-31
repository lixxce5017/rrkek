import java.lang.Math.max
typealias BinaryVisitor<T> = (T) -> Unit
class BinaryNode<T>(var value: T){
    var leftChild: BinaryNode<T>? =null
    var rightChild: BinaryNode<T>?=null
    val min: BinaryNode<T>?
        get()= leftChild?.min?:this

    fun height(node: BinaryNode<T>?= this): Int{
        return node?.let{
            1+max(height(node.leftChild),height(node.rightChild))
        } ?: -1
    }

    fun travdrseInOrder(visit: BinaryVisitor<T>){
        leftChild?.travdrseInOrder(visit)
        visit(value)
        rightChild?.travdrseInOrder(visit)
    }

    fun traversePreOrder(visit: BinaryVisitor<T>)
    {
        visit(value)
        leftChild?.travdrseInOrder(visit)
        rightChild?.travdrseInOrder(visit)
    }

    fun traversePostOrder(visit: BinaryVisitor<T>)
    {
        rightChild?.travdrseInOrder(visit)
        visit(value)
        leftChild?.travdrseInOrder(visit)

    }
    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" +
                        diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
    override  fun toString() =diagram(this)
}