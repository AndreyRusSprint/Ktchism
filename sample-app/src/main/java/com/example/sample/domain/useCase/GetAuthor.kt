package com.example.sample.domain.useCase

import com.example.sample.domain.entity.Author
import com.example.sample.domain.repository.AuthorRepository
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either
import ktchism.interactor.UseCase

class GetAuthor(
    private val authorRepository: AuthorRepository
) : UseCase<Single<Either<Failure, Author>>, GetAuthor.Params>() {

    override fun constructResult(params: Params): Single<Either<Failure, Author>> =
        authorRepository.author(params.id)

    class Params(val id: Int)
}
