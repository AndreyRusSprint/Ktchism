package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.functional.*

/**
 * Returns an Observable<Either> that emits items based on applying a function that you supply to each item emitted
 * by the source ObservableSource, where that function returns an ObservableSource<Either>, and then merging those
 * resulting ObservableSources and emitting the results of this merger.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source ObservableSource,
 *          returns an ObservableSource<Either>.
 * @return an Observable<Either> that emits the result of applying the transformation function to each item emitted
 *         by the source ObservableSource<Either> and merging the results of the ObservableSources obtained from
 *         this transformation.
 * @see Observable.flatMap
 */
fun <T, L, R> Observable<Either<L, R>>.flatMapRight(
    fn: (R) -> Observable<Either<L, T>>
): Observable<Either<L, T>> = this.flatMap { item ->
    item.fold({ Observable.just(Either.left(it)) }, { fn(it) })
}

/**
 * Returns a Single<Either> that is based on applying a specified function to the item emitted by the source Single,
 * where that function returns a SingleSource<Either>.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source Single,
 *          returns a SingleSource<Either>.
 * @return the Single<Either> returned from [fn] when applied to the right side of Either emitted by the
 *         source Single.
 * @see Single.flatMap
 */
fun <T, L, R> Single<Either<L, R>>.flatMapRight(
    fn: (R) -> Single<Either<L, T>>
): Single<Either<L, T>> = this.flatMap { item ->
    item.fold({ Single.just(Either.left(it)) }, { fn(it) })
}

/**
 * Returns a Flowable<Either> that emits items based on applying a function that you supply to each item emitted
 * by the source Publisher, where that function returns a Publisher, and then merging those resulting
 * Publishers and emitting the results of this merger.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source Publisher,
 *          returns a Publisher<Either>.
 * @return a Flowable<Either> that emits the result of applying the transformation function to each item
 *         emitted by the source Publisher and merging the results of the Publishers obtained from this
 *         transformation.
 * @see Flowable.flatMap
 */
fun <T, L, R> Flowable<Either<L, R>>.flatMapRight(
    fn: (R) -> Flowable<Either<L, T>>
): Flowable<Either<L, T>> = this.flatMap { item ->
    item.fold({ Flowable.just(Either.left(it)) }, { fn(it) })
}

/**
 * Returns an Observable<Either> that emits items based on applying a right-biased Either.flatMap() function,
 * the argument of which is the specified function, to each item emitted by the source ObservableSource,
 * where that function returns an Either, and then merging those resulting Either-items and emitting
 * the results of this merger.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source ObservableSource,
 *          returns an Either.
 * @return an Observable<Either> that emits the result of applying the Either.flatMap() function to each item
 *         emitted by the source ObservableSource and merging the results of the Either-items obtained from
 *         this transformation.
 * @see Either.flatMap
 */
fun <T, L, R> Observable<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Observable<Either<L, T>> = this.map {
    it.flatMap(fn)
}

/**
 * Returns a Single<Either> that is based on applying a right-biased Either.flatMap() function, the argument of which
 * is the specified function, to the item emitted by the source Single, where that function returns an Either.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source Single,
 *          returns an Either.
 * @return the Single<Either> that emits the result of applying the Either.flatMap() function to the item emitted
 *         by the source Single.
 * @see Either.flatMap
 */
fun <T, L, R> Single<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Single<Either<L, T>> = this.map {
    it.flatMap(fn)
}

/**
 * Returns a Flowable<Either> that emits items based on applying a right-biased Either.flatMap() function,
 * the argument of which is the specified function, to each item emitted by the source Publisher,
 * where that function returns an Either, and then merging those resulting Either-items and emitting
 * the results of this merger.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function that, when applied to the right side of Either emitted by the source Publisher,
 *          returns an Either.
 * @return a Flowable<Either> that emits the result of applying the Either.flatMap() function to each item
 *         emitted by the source Publisher and merging the results of the Either-items obtained from this
 *         transformation.
 * @see Either.flatMap
 */
fun <T, L, R> Flowable<Either<L, R>>.flatMapEither(
    fn: (R) -> Either<L, T>
): Flowable<Either<L, T>> = this.map {
    it.flatMap(fn)
}

/**
 * Returns an Observable<Either> that applies a right-biased Either.map() function, the argument of which
 * is the specified function, to each item emitted by the source ObservableSource and emits the results
 * of these function applications.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.map() function to each item
 *          emitted by the ObservableSource.
 * @return an Observable<Either> that emits the items from the source ObservableSource, transformed
 *         by the Either.map() function, the argument of which is the specified function.
 * @see Either.map
 */
fun <T, L, R> Observable<Either<L, R>>.mapEither(
    fn: (R) -> T
): Observable<Either<L, T>> = this.map {
    it.map(fn)
}

/**
 * Returns a Single<Either> that applies a right-biased Either.map() function, the argument of which
 * is the specified function, to the item emitted by the source Single and emits the result
 * of this function application.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.map() function to the item
 *          emitted by the Single.
 * @return a Single<Either> that emits the item from the source Single, transformed by the
 *         Either.map() function, the argument of which is the specified function.
 * @see Either.map
 */
fun <T, L, R> Single<Either<L, R>>.mapEither(
    fn: (R) -> T
): Single<Either<L, T>> = this.map {
    it.map(fn)
}

/**
 * Returns a Flowable<Either> that applies a right-biased Either.map() function, the argument of which
 * is the specified function, to each item emitted by the source Publisher and emits the results
 * of these function applications.
 *
 * @param T the type of the right side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.map() function to each item
 *          emitted by the Publisher.
 * @return a Flowable<Either> that emits the items from the source Publisher, transformed by the
 *         Either.map() function, the argument of which is the specified function.
 * @see Either.map
 */
fun <T, L, R> Flowable<Either<L, R>>.mapEither(
    fn: (R) -> T
): Flowable<Either<L, T>> = this.map {
    it.map(fn)
}

/**
 * Returns an Observable<Either> that applies a left-biased Either.mapLeft() function, the argument of which
 * is the specified function, to each item emitted by the source ObservableSource and emits the results
 * of these function applications.
 *
 * @param T the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.mapLeft() function to each item
 *          emitted by the ObservableSource.
 * @return an Observable<Either> that emits the items from the source ObservableSource, transformed by the
 *         Either.mapLeft() function, the argument of which is the specified function.
 * @see Either.mapLeft
 */
fun <T, L, R> Observable<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Observable<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

/**
 * Returns a Single<Either> that applies a left-biased Either.mapLeft() function, the argument of which
 * is the specified function, to the item emitted by the source Single and emits the result
 * of this function application.
 *
 * @param T the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.mapLeft() function to the item
 *          emitted by the Single.
 * @return a Single<Either> that emits the item from the source Single, transformed by the
 *         Either.mapLeft() function, the argument of which is the specified function.
 * @see Either.mapLeft
 */
fun <T, L, R> Single<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Single<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

/**
 * Returns a Flowable<Either> that applies a left-biased Either.mapLeft() function, the argument of which
 * is the specified function, to each item emitted by the source Publisher and emits the results
 * of these function applications.
 *
 * @param T the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fn
 *          a function to pass as argument to apply Either.mapLeft() function to each item
 *          emitted by the Publisher.
 * @return a Flowable<Either> that emits the items from the source Publisher, transformed by the
 *         Either.mapLeft() function, the argument of which is the specified function.
 * @see Either.mapLeft
 */
fun <T, L, R> Flowable<Either<L, R>>.mapLeftEither(
    fn: (L) -> T
): Flowable<Either<T, R>> = this.map {
    it.mapLeft(fn)
}

/**
 * Returns an Observable<Either> that applies a Either.bimap() function, the arguments of which
 * are the specified functions, to each item emitted by the source ObservableSource and emits the results
 * of these function applications.
 *
 * @param T the type of the right side of resulting [Either].
 * @param E the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fnL
 *          a function to pass as left-biased argument to apply Either.bimap() function to each item
 *          emitted by the ObservableSource.
 * @param fnR
 *          a function to pass as right-biased argument to apply Either.bimap() function to each item
 *          emitted by the ObservableSource.
 * @return an Observable<Either> that emits the items from the source ObservableSource, transformed by the
 *         Either.bimap() function, the arguments of which are the specified functions.
 * @see Either.bimap
 */
fun <T, E, L, R> Observable<Either<L, R>>.bimapEither(
    fnL: (L) -> E,
    fnR: (R) -> T
): Observable<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}

/**
 * Returns a Single<Either> that applies a Either.bimap() function, the arguments of which
 * are the specified functions, to the item emitted by the source Single and emits the result
 * of this function applications.
 *
 * @param T the type of the right side of resulting [Either].
 * @param E the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fnL
 *          a function to pass as left-biased argument to apply Either.bimap() function to the item
 *          emitted by the Single.
 * @param fnR
 *          a function to pass as right-biased argument to apply Either.bimap() function to the item
 *          emitted by the Single.
 * @return a Single<Either> that emits the item from the source Single, transformed by the
 *         Either.bimap() function, the arguments of which are the specified functions.
 * @see Either.bimap
 */
fun <T, E, L, R> Single<Either<L, R>>.bimapEither(
    fnL: (L) -> E,
    fnR: (R) -> T
): Single<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}

/**
 * Returns a Flowable<Either> that applies a Either.bimap() function, the arguments of which
 * are the specified functions, to each item emitted by the source Publisher and emits the results
 * of these function applications.
 *
 * @param T the type of the right side of resulting [Either].
 * @param E the type of the left side of resulting [Either].
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param fnL
 *          a function to pass as left-biased argument to apply Either.bimap() function to each item
 *          emitted by the Publisher.
 * @param fnR
 *          a function to pass as right-biased argument to apply Either.bimap() function to each item
 *          emitted by the Publisher.
 * @return a Flowable<Either> that emits the items from the source Publisher, transformed by the
 *         Either.bimap() function, the arguments of which are the specified functions.
 * @see Either.bimap
 */
fun <T, E, L, R> Flowable<Either<L, R>>.bimapEither(
    fnL: (L) -> E,
    fnR: (R) -> T
): Flowable<Either<E, T>> = this.map {
    it.bimap(fnL, fnR)
}

/**
 * Ignores all right items emitted by the source ObservableSource and returns [Unit] instead.
 *
 * @return an Observable<Either<L, Unit>>
 */
fun <L, R> Observable<Either<L, R>>.ignoreRight(): Observable<Either<L, Unit>> =
    this.mapEither { Unit }

/**
 * Ignores the right value of this [Single] and returns [Unit] instead.
 *
 * @return a Single<Either<Left, Unit>>
 */
fun <L, R> Single<Either<L, R>>.ignoreRight(): Single<Either<L, Unit>> =
    this.mapEither { Unit }

/**
 * Ignores all right items emitted by the source Publisher and returns [Unit] instead.
 *
 * @return a Flowable<Either<L, Unit>>
 */
fun <L, R> Flowable<Either<L, R>>.ignoreRight(): Flowable<Either<L, Unit>> =
    this.mapEither { Unit }

fun <L, R> Observable<Either<L, R>>.onFailureReturn(
    fn: (L) -> R
): Observable<Either<L, R>> = this.map { result ->
    if (result is Either.Left<L>) {
        Either.right(fn(result.value))
    } else {
        result
    }
}

fun <L, R> Single<Either<L, R>>.onFailureReturn(
    fn: (L) -> R
): Single<Either<L, R>> = this.map { result ->
    if (result is Either.Left<L>) {
        Either.right(fn(result.value))
    } else {
        result
    }
}

fun <L, R> Flowable<Either<L, R>>.onFailureReturn(
    fn: (L) -> R
): Flowable<Either<L, R>> = this.map { result ->
    if (result is Either.Left<L>) {
        Either.right(fn(result.value))
    } else {
        result
    }
}
