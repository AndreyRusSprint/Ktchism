@file:Suppress("USELESS_CAST")

package ktchism.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either

fun <T> Observable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Observable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T> Single<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T> Flowable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Flowable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun Completable.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, Unit>> = this
    .toSingleDefault(Unit)
    .toEither(exceptionMapper)
