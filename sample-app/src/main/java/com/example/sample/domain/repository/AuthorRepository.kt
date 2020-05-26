package com.example.sample.domain.repository

import com.example.sample.domain.entity.Author
import io.reactivex.Single
import ktchism.exception.Failure
import ktchism.functional.Either

interface AuthorRepository {
    fun authors(): Single<Either<Failure, List<Author>>>
    fun author(id: Int): Single<Either<Failure, Author>>
}
