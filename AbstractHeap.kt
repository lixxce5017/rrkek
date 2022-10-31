import java.util.Collections
abstract class AbstractHeap<Element>() : HeapInterface<Element>
{
    var elements: ArrayList<Element> = ArrayList<Element>()
    override val count: Int
        get() = elements.size

    override fun peek(): Element?  = elements.first()
    private fun leftChilIndex(index: Int) = (2*index)+1
    private fun rightChildIndex(index: Int) =(2*index)+2
    private fun parentIndex(index: Int) = (index -1) /2

    abstract fun compare(a: Element, b:Element): Int

    override fun insert(element: Element)
    {
        elements.add(element)
        siftUp(count -1)
    }
    private fun siftUp(index: Int)
    {
        var child =index
        var parent =parentIndex(child)
        while(child> 0 && compare(elements[child],elements[parent])>0)
        {
            Collections.swap(elements,child,parent)
            child = parent
            parent =parentIndex(child)
        }
    }
    private fun siftDown(index: Int)
    {
        var parent = index
        while(true)
        {
            val left =leftChilIndex(parent)
            val right = rightChildIndex(parent)
            var candidate = parent
            if(left< count &&
                compare(elements[left], elements[candidate])>0)
                {
                    candidate =left
                }
            if(right < count && compare(elements[right], elements[candidate])>0)
            {   candidate=right
            }
            if (candidate==parent)
                return
            Collections.swap(elements,parent,candidate)
            parent = candidate
        }
    }
    override fun remove():Element? {
        if(isEmpty) return null
        Collections.swap(elements,0,count -1)
        val item =elements.removeAt(count -1)
        siftDown(0)
        return item
    }
    
}
