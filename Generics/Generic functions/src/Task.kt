import java.util.*
import java.util.function.BiPredicate

fun <T, C: MutableCollection<T>> Collection<T>.partitionTo(listA: C, listB: C, predicate: (T) -> Boolean) : Pair<C,C>
{
    this.partition(predicate).first.toCollection(listA)
    this.partition(predicate).second.toCollection(listB)
    return Pair(listA, listB)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }
    check(words == listOf("a", "c"))
    check(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
    check(letters == setOf('a', 'r'))
    check(other == setOf('%', '}'))
}
