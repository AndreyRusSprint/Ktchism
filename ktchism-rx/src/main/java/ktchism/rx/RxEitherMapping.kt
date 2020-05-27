package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.functional.*

fun <T, L, R> Observable<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Observable<Either<L, T>> = this.map {
    it.flatMap(fn)
}

fun <T, L, R> Single<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Single<Either<L, T>> = this.map {
    it.flatMap(fn)
}

fun <T, L, R> Flowable<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Flowable<Either<L, T>> = this.map {
    it.flatMap(fn)
}

fun <T, L, R> Observable<Either<L, R>>.mapEither(
    fn: (R) -> T
): Observable<Either<L, T>> = this.map {
    it.map(fn)
}

fun <T, L, R> Single<Either<L, R>>.mapEither(
    fn: (R) -> T
): Single<Either<L, T>> = this.map {
    it.map(fn)
}

fun <T, L, R> Flowable<Either<L, R>>.mapEither(
    fn: (R) -> T
): Flowable<Either<L, T>> = this.map {
    it.map(fn)
}

fun <T, L, R> Observable<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Observable<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

fun <T, L, R> Single<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Single<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

fun <T, L, R> Flowable<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Flowable<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

fun <T, E, L, R> Observable<Either<L, R>>.bimapEither(
    fnL: (L) -> E, fnR: (R) -> T
): Observable<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}

fun <T, E, L, R> Single<Either<L, R>>.bimapEither(
    fnL: (L) -> E, fnR: (R) -> T
): Single<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}

fun <T, E, L, R> Flowable<Either<L, R>>.bimapEither(
    fnL: (L) -> E, fnR: (R) -> T
): Flowable<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}
