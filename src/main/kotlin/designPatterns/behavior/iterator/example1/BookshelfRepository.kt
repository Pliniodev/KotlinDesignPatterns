package designPatterns.behavior.iterator.example1

import designPatterns.behavior.iterator.example1.model.Book

class BookshelfRepository {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun removeBookIfExists(title: String) {
        val filteredBooks = books.filter { title in it.title }
        filteredBooks.forEach { books.remove(it) }
    }

    fun searchByAuthor(author: String): List<Book> {
        return books.filter { author in it.author  }
    }

    fun searchByTitle(title: String): List<Book> {
        return books.filter { title in it.title }
    }

    fun getIterator() = DefaultIterator(this)
    fun getSortedByAuthorIterator() = SortedByAuthorBookIterator(this)
    fun getSortedByTitleIterator() = SortedByTitleIterator(this)

    // -----------------Iterators -------------- //

    inner class DefaultIterator(private val bookshelf: BookshelfRepository) : BookIterator {
        private var index = 0

        override fun hasNext(): Boolean {
            return index < bookshelf.books.size
        }

        override fun next(): Book? {
            return if (hasNext()) bookshelf.books[index++] else null
        }
    }

    inner class SortedByAuthorBookIterator(bookshelf: BookshelfRepository) : BookIterator {
        private val sortedBooks = bookshelf.books.sortedBy { it.author }
        private var index = 0

        override fun hasNext(): Boolean {
            return index < sortedBooks.size
        }

        override fun next(): Book? {
            return if (hasNext()) sortedBooks[index++] else null
        }
    }

    inner class SortedByTitleIterator(bookshelf: BookshelfRepository) : BookIterator {
        private val sortedBooks = bookshelf.books.sortedBy { it.title }
        private var index = 0

        override fun hasNext(): Boolean {
            return index < sortedBooks.size
        }

        override fun next(): Book? {
            return if (hasNext()) sortedBooks[index++] else null
        }
    }
}
