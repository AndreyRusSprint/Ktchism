package com.example.sample.domain.useCase

import com.example.sample.domain.entity.Book
import com.example.sample.domain.repository.BookRepository
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either
import ktchism.interactor.UseCase

class GetBook(
    private val bookRepository: BookRepository
) : UseCase<Single<Either<Failure, Book>>, GetBook.Params>() {

    override fun constructResult(params: Params): Single<Either<Failure, Book>> =
        bookRepository.book(params.id)

    class Params(val id: Int)
}
