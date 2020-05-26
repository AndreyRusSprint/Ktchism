package com.example.sample.domain.useCase

import com.example.sample.domain.entity.Author
import com.example.sample.domain.repository.AuthorRepository
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either
import ktchism.interactor.UseCase

class GetAuthors(
    private val authorRepository: AuthorRepository
) : UseCase<Single<Either<Failure, List<Author>>>, UseCase.None>() {

    override fun constructResult(params: None): Single<Either<Failure, List<Author>>> =
        authorRepository.authors()
}
