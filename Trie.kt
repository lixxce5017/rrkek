class Trie<Key> {
    private  val root = TrieNode<Key>(key =null, parent = null)

    fun insert(list: List<Key>) {
        var current = root
        list.forEach{ element ->
            if(current.children[element]== null) {
                current.children[element] = TrieNode(element,current)

            }
            current =current.children[element]!!
        }
        current.isTerminating= true
        storedList.add(list)
}

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
        current = child}
        return current.isTerminating
    }
    fun Trie<Char>.insert(string: String){
        insert(string.toString())
    }
    fun Trie<Char>.contains(string: String):Boolean
    {
        return contains(string.toList())
    }

    fun remove(collection: List<Key>)
    {
        var current =root
        collection.forEach{
            val child = current.children[it]?: return
            current = child
        }
        if(!current.isTerminating) return
        current.isTerminating = false
        storedList.remove(collection)
        val parent = current.parent
        while(current.children.isEmpty() && !current.isTerminating)
        {
            parent?.let{
                it.children[current.key!!] = null
                current =it
            }
        }

    }
    fun collections(prefix: List<Key>): List<List<Key>> {
        var current =root
        prefix.forEach{ element->
            val child = current.children[element] ?: return emptyList()
            current =  child
        }
        return collections(prefix, current)
    }
    private fun collections(prefix:List<Key>, node:TrieNode<Key>?):List<List<Key>>
    {
        val results = mutableListOf<List<Key>>()
        if(node?. isTerminating == true)
            results.add(prefix)
        node?.children?.forEach{ (key,node) ->
            results.addAll(collections(prefix + key,node))
        }
        return results
    }
    fun Trie<Char>.collections(prefix: String): List<String>
    {
        return collections(prefix.toList()).map{
            it.joinToString (separator = "")
        }
    }
    private  val storedList: MutableSet<List<Key>> = mutableSetOf()
    val lists: List<List<Key>>
        get() = storedList.toList()
}