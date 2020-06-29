@file:Suppress("USELESS_CAST")

package ktchism.rx

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either
import ktchism.core.mapper.ExceptionMapper

/**
 * Converts the current Observable into a Observable<Either> by applying the specified exception mapper function.
 *
 * @param T the type of the items emitted by the [Observable].
 * @param exceptionMapper a function to convert [Throwable] to [Failure].
 * @return [Observable] with [Either] type of emitted items.
 */
fun <T> Observable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Observable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

/**
 * Converts the current Observable into a Observable<Either> by applying the specified exception mapper.
 *
 * @param T the type of the items emitted by the [Observable].
 * @param exceptionMapper the exception mapper to apply.
 * @return [Observable] with [Either] type of emitted items.
 */
fun <T> Observable<T>.toEither(
    exceptionMapper: ExceptionMapper
): Observable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

/**
 * Converts the current Single into a Single<Either> by applying the specified exception mapper function.
 *
 * @param T the type of the item emitted by the [Single].
 * @param exceptionMapper a function to convert [Throwable] to [Failure].
 * @return [Single] with [Either] type of emitted item.
 */
fun <T> Single<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

/**
 * Converts the current Single into a Single<Either> by applying the specified exception mapper.
 *
 * @param T the type of the item emitted by the [Single].
 * @param exceptionMapper the exception mapper to apply.
 * @return [Single] with [Either] type of emitted item.
 */
fun <T> Single<T>.toEither(
    exceptionMapper: ExceptionMapper
): Single<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

/**
 * Converts the current Flowable into a Flowable<Either> by applying the specified exception mapper function.
 *
 * @param T the type of the items emitted by the [Flowable].
 * @param exceptionMapper a function to convert [Throwable] to [Failure].
 * @return [Flowable] with [Either] type of emitted items.
 */
fun <T> Flowable<T>.toEither(
    exceptionMapper: (Throwable) -> Failure
): Flowable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper(it)) }

/**
 * Converts the current Flowable into a Flowable<Either> by applying the specified exception mapper.
 *
 * @param T the type of the items emitted by the [Flowable].
 * @param exceptionMapper the exception mapper to apply.
 * @return [Flowable] with [Either] type of emitted items.
 */
fun <T> Flowable<T>.toEither(
    exceptionMapper: ExceptionMapper
): Flowable<Either<Failure, T>> = this
    .map { Either.right(it) as Either<Failure, T> }
    .onErrorReturn { Either.left(exceptionMapper.transform(it)) }

/**
 * Converts the current Completable into a Single<Either> by applying the specified exception mapper function.
 * [Either.Right] type is always [Unit].
 *
 * @param exceptionMapper a function to convert [Throwable] to [Failure].
 * @return [Single] with [Either] type of emitted item.
 */
fun Completable.toEither(
    exceptionMapper: (Throwable) -> Failure
): Single<Either<Failure, Unit>> = this
    .toSingleDefault(Unit)
    .toEither(exceptionMapper)

/**
 * Converts the current Completable into a Single<Either> by applying the specified exception mapper.
 * [Either.Right] type is always [Unit].
 *
 * @param exceptionMapper the exception mapper to apply.
 * @return [Single] with [Either] type of emitted items.
 */
fun Completable.toEither(
    exceptionMapper: ExceptionMapper
): Single<Either<Failure, Unit>> = this
    .toSingleDefault(Unit)
    .toEither(exceptionMapper)
