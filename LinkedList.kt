import java.lang.IndexOutOfBoundsException
//T : Any 유형 매개변수의 상한을 설정하는 데 사용 T하면 항상 널 입력 불가 유형이 됩니다.
class LinkedList<T>: Iterable<T>, Collection<T> {
    private var head: Node<T>?=null
    private var tail: Node<T>?=null
    override var size = 0
        private set

    override fun iterator(): Iterator<T> {
        return LinkedListIterator(this)
    }

    override fun  isEmpty(): Boolean{
        return size ==0
    }

    override fun contains(element:T): Boolean{
        for(item in this)
            if (item == element) return true
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for(searched in elements)
            if(!contains(searched)) return false
        return true
    }


    override fun toString(): String {
        if(isEmpty())
        {
            return "Empty List"
        }
        return head.toString()
    }
    fun push(value:T): Int{
        head = Node(value = value, next = head)
        if(tail == null){
            tail = head
        }
        size++
        return size
    }

    fun append(value: T)
    {
        if (isEmpty()) {
            push(value)
            return
        }
        val newNode = Node(value =value)
        tail!!.next = newNode

        tail = newNode
        size++
    }

    fun nodeAt(index:Int): Node<T>?{
        var currentNode = head
        var currentIndex = 0
        while (currentNode != null && currentIndex <index) {
            currentNode = currentNode.next
            currentIndex++

        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>{
        if(tail == afterNode)
        {
            append(value)
            return tail!!
        }
        val newNode =Node(value = value, next = afterNode.next)
        afterNode.next =newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if(!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty())
        {
            tail = null
        }
        return result
    }
    fun removeLast(): T? {
        val head = head?: return null
        if (head.next == null) return pop()
        size --
        var prev = head
        var current = head
        var next = current.next
        while(next != null)
        {
            prev =current
            current = next
            next = current.next
        }
        prev.next =null
        tail = prev
        return current.value
    }
    fun removeAfter(node: Node<T>): T? {
        val result =node.next?.value
        if(node.next == tail)
        {
            tail =node
        }
        if(node.next != null)
        {
            size --
        }
        node.next = node.next?.next
        return result
    }

    fun removeHead(): T? {
        val head = head ?: return null
        size --
        this.head = head.next
        if(isEmpty())
            this.tail = null
        return head.value
    }
    fun printInReverse()
    {
        this.nodeAt(0)?.printInReverse()
    }

    fun getMiddle(): Node<T>? {
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)
        while (fast != null){
            fast = fast.next
            if(fast != null){

            }

        }
        return slow

    }
}
class LinkedListIterator<K> (
    private val list: LinkedList<K>): Iterator<K> {
    private  var index =0
    private var lastNode: Node<K>? =null

    override  fun next():K {
        if (index >= list.size) throw IndexOutOfBoundsException()
        lastNode = if(index==0) {
            list.nodeAt(0)
        }else
            lastNode?.next
        index++
        return lastNode!!.value
    }

    override fun hasNext(): Boolean {
        return index< list.size
    }

    fun <T: Any>LinkedList<T>.getMiddle(): Node<T>?
    {
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)

        while(fast != null){
            fast = fast.next
            if(fast != null)
            {
                fast =fast.next
                slow =slow?.next
            }
        }
        return slow?.next
    }
        private  fun<T: Any> addInReverse(list: LinkedList<T>, node: Node<T>)
        {
            val next = node.next
            if(next != null)
            {
                addInReverse(list, next)
            }
            list.append(node.value)
        }

        fun <T: Any>LinkedList<T>.reversed(): LinkedList<T> {
            val result = LinkedList<T>()
            val head =this.nodeAt(0)
            if(head!= null)
            {
                addInReverse(result,head)
            }
            return result
        }



    }

