package com.example.sample.data.dataSource

import com.example.sample.data.model.AuthorLocal
import com.example.sample.data.model.BookLocal
import io.reactivex.Single

class BookLocalDataStore {

    fun getAll(): Single<List<BookLocal>> = Single.just(books)

    fun getBy(id: Int): Single<BookLocal> = Single.create { emitter ->
        val book = books.firstOrNull { it.id == id }
        if (book != null) {
            if (!emitter.isDisposed) emitter.onSuccess(book)
        } else {
            if (!emitter.isDisposed) emitter.onError(NoSuchElementException())
        }
    }

    private val books by lazy {
        listOf(
            BookLocal(id = 0, name = "Book 1", author = AuthorLocal(id = 0, name = "Author 1")),
            BookLocal(id = 1, name = "Book 2", author = AuthorLocal(id = 1, name = "Author 2")),
            BookLocal(id = 2, name = "Book 3", author = AuthorLocal(id = 2, name = "Author 3")),
            BookLocal(id = 3, name = "Book 4", author = AuthorLocal(id = 3, name = "Author 4"))
        )
    }
}
