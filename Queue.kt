
class ArrayListQueue<T>: QueueInterface<T>{
    private val list = arrayListOf<T>()
    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if (isEmpty) null
        else list.removeAt(0)

    override fun toString(): String = list.toString()

    fun <T : Any> QueueInterface<T>.reverse() {
        // 1
        val aux = Stack<T>()

        // 2
        var next = this.dequeue()
        while (next != null) {
            aux.push(next)
            next = this.dequeue()
        }

        // 3
        next = aux.pop()
        while (next != null) {
            this.enqueue(next)
            next = aux.pop()
        }
    }
}
class LinkedListQueue<T> : QueueInterface<T> {
    private  val list = LinkedList<T>()
    private  var size = 0
    override val count: Int
        get() =size

    override fun peek(): T? = list.nodeAt(0)?.value
    override fun enqueue(element: T): Boolean {
        list.append(element)
        size++
        return true
    }

    override fun dequeue(): T? {
        val firstNode =list.nodeAt(0)?: return null
        size --
        return list.removeHead()
    }

    override fun toString(): String  = list.toString()


}


