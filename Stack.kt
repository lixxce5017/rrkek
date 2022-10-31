class Stack<Element>() :StackInterface<Element> {
    private val storage = arrayListOf<Element>()
    override fun toString() = buildString {
        appendLine("-------top------")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("--------------")
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun pop(): Element? {

        if (storage.size == 0)
        {return null
        }

        return storage.removeAt(storage.size - 1)
    }

}