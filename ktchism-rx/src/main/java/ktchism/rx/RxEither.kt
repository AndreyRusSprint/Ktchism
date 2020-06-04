@file:Suppress("USELESS_CAST")

package ktchism.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either
import ktchism.core.mapper.ExceptionMapper

fun <T> Observable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Observable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T> Observable<T>.toEither(
    exceptionMapper: ExceptionMapper
): Observable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

fun <T> Single<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T> Single<T>.toEither(
    exceptionMapper: ExceptionMapper
): Single<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

fun <T> Flowable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Flowable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

fun <T> Flowable<T>.toEither(
    exceptionMapper: ExceptionMapper
): Flowable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

fun Completable.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, Unit>> = this
    .toSingleDefault(Unit)
    .toEither(exceptionMapper)

fun Completable.toEither(
    exceptionMapper: ExceptionMapper
): Single<Either<Failure, Unit>> = this
    .toSingleDefault(Unit)
    .toEither(exceptionMapper)
