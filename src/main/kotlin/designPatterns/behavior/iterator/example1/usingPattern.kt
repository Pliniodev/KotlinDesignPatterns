package designPatterns.behavior.iterator.example1

import designPatterns.behavior.iterator.example1.model.Book
import divider

fun main() {
    val repository = BookshelfRepository()
    populateBookshelf(repository)

    val defaultIterator = repository.getIterator()
    val sortedByAuthorIterator = repository.getSortedByAuthorIterator()
    val sortedByTitleIterator = repository.getSortedByTitleIterator()

    iterateInBookshelf(defaultIterator)
    iterateInSortedByAuthorBookshelf(sortedByAuthorIterator)
    iterateInSortedByTitleBookshelf(sortedByTitleIterator)

    searchByAuthor(repository, author = "Ramos")
    searchByTitle(repository, title = "Dom")

    removeBooks(repository, title = "Dom")
}

private fun removeBooks(repository: BookshelfRepository, title: String) {
    repository.removeBookIfExists(title)
    divider()
    println("Remaining Books")
    divider()
    val iterator = repository.getIterator()
    while (iterator.hasNext()){
        val currentBook = iterator.next()
        println(currentBook.toString())
    }
}

private fun searchByAuthor(repository: BookshelfRepository, author: String) {
    val searchedBooks = repository.searchByAuthor(author)
    divider()
    println("Searched books by author")
    divider()
    searchedBooks.forEach { println(it.toString()) }
}

private fun searchByTitle(repository: BookshelfRepository, title: String) {
    val searchedBooks = repository.searchByTitle(title)
    divider()
    println("Searched books by title")
    divider()
    searchedBooks.forEach { println(it.toString()) }
}

private fun iterateInBookshelf(iterator: BookIterator) {
    divider()
    println("Default iterator")
    divider()
    while (iterator.hasNext()){
        val currentBook = iterator.next()
        println(currentBook.toString())
    }
}

private fun iterateInSortedByAuthorBookshelf(iterator: BookIterator) {
    divider()
    println("Sorted by author iterator")
    divider()
    while (iterator.hasNext()){
        val currentBook = iterator.next()
        println(currentBook.toString())
    }
}

private fun iterateInSortedByTitleBookshelf(iterator: BookIterator) {
    divider()
    println("Sorted by title iterator")
    divider()
    while (iterator.hasNext()){
        val currentBook = iterator.next()
        println(currentBook.toString())
    }
}

private fun populateBookshelf(bookshelf: BookshelfRepository) {
    bookshelf.addBook(Book(title = "Grande sertão Veredas", author = "João Guimarães Rosa"))
    bookshelf.addBook(Book(title = "Memórias póstumas de Brás Cubas", author = "Machado de Assis"))
    bookshelf.addBook(Book(title = "Dom Casmurro ", author = "Machado de Assis"))
    bookshelf.addBook(Book(title = "Vidas secas", author = "Graciliano Ramos"))
    bookshelf.addBook(Book(title = "São Bernardo", author = "Graciliano Ramos"))
}
