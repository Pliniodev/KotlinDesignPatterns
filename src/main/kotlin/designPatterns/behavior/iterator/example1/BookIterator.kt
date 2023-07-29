package designPatterns.behavior.iterator.example1

import designPatterns.behavior.iterator.example1.model.Book

interface BookIterator {
    fun hasNext(): Boolean
    fun next(): Book?
}