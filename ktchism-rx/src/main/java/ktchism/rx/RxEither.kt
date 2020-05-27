@file:Suppress("USELESS_CAST")

package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either

fun <T, E : Failure> Observable<T>.toEither(
    exceptionMapper: (Throwable) -> E
): Observable<Either<E, T>> = this
    .map { Either.right(it) as Either<E, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T, E : Failure> Single<T>.toEither(
    exceptionMapper: (Throwable) -> E
): Single<Either<E, T>> = this
    .map { Either.right(it) as Either<E, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T, E : Failure> Flowable<T>.toEither(
    exceptionMapper: (Throwable) -> E
): Flowable<Either<E, T>> = this
    .map { Either.right(it) as Either<E, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }
