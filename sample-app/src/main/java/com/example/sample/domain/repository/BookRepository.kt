package com.example.sample.domain.repository

import com.example.sample.domain.entity.Book
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either

interface BookRepository {
    fun books(): Single<Either<Failure, List<Book>>>
    fun book(id: Int): Single<Either<Failure, Book>>
}
