package com.example.sample.domain.useCase

import com.example.sample.domain.entity.Book
import com.example.sample.domain.repository.BookRepository
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either
import ktchism.interactor.UseCase

class GetBooks(
    private val bookRepository: BookRepository
) : UseCase<Single<Either<Failure, List<Book>>>, UseCase.None>() {

    override fun constructResult(params: None): Single<Either<Failure, List<Book>>> =
        bookRepository.books()
}
