
fun <T: Comparable<T>> ArrayList<T>.binarySearch(value: T, range: IntRange = indices):Int?
{
    if(range.first > range. last)
        return null

    val size = range.last - range.first +1
    val middel = range.first + size/2
    return when {
        this[middel] == value -> middel
        this[middel] > value ->binarySearch (value,range.first  until middel)
        else-> binarySearch( value, (middel +1)..range.last)
    }
}