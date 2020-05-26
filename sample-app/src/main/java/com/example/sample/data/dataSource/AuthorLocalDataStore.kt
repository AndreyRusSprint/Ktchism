package com.example.sample.data.dataSource

import com.example.sample.data.model.AuthorLocal
import io.reactivex.Single

class AuthorLocalDataStore {

    fun getAll(): Single<List<AuthorLocal>> = Single.just(authors)

    fun getBy(id: Int): Single<AuthorLocal> = Single.create { emitter ->
        val author = authors.firstOrNull { it.id == id }
        if (author != null) {
            if (!emitter.isDisposed) emitter.onSuccess(author)
        } else {
            if (!emitter.isDisposed) emitter.onError(NoSuchElementException())
        }
    }

    private val authors by lazy {
        listOf(
            AuthorLocal(id = 0, name = "Author 1"),
            AuthorLocal(id = 1, name = "Author 2"),
            AuthorLocal(id = 2, name = "Author 3")
        )
    }
}
