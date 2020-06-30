package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import ktchism.core.functional.Either

/**
 * Subscribes to an ObservableSource and provides callbacks to handle the Either-items it emits or
 * completion notification it issues.
 *
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param ifLeft
 *             a function to accept Either.Left emissions from the ObservableSource.
 * @param ifRight
 *             a function to accept Either.Right emissions from the ObservableSource.
 * @param ifComplete
 *             a function to accept a completion notification from the ObservableSource.
 * @return a [Disposable] reference with which the caller can stop receiving items before
 *         the ObservableSource has finished sending them.
 * @see Either.fold
 */
fun <L, R> Observable<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit = {},
    ifRight: (R) -> Unit = {},
    ifComplete: () -> Unit = {}
): Disposable = this.subscribeBy(
    onNext = { it.fold(ifLeft, ifRight) },
    onComplete = { ifComplete() },
    onError = { it.printStackTrace() }
)

/**
 * Subscribes to a Single and provides callbacks to handle the Either-item it emits.
 *
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param ifLeft
 *             a function to accept Either.Left emission from the Single.
 * @param ifRight
 *             a function to accept Either.Right emission from the Single.
 * @return a [Disposable] reference can request the [Single] stop work.
 * @see Either.fold
 */
fun <L, R> Single<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit = {},
    ifRight: (R) -> Unit = {}
): Disposable = this.subscribeBy(
    onSuccess = { it.fold(ifLeft, ifRight) },
    onError = { it.printStackTrace() }
)

/**
 * Subscribes to a Publisher and provides callbacks to handle the Either-items it emits or
 * completion notification it issues.
 *
 * @param L the type of the left side of source [Either].
 * @param R the type of the right side of source [Either].
 * @param ifLeft
 *             a function to accept Either.Left emissions from the Publisher.
 * @param ifRight
 *             a function to accept Either.Right emissions from the Publisher.
 * @param ifComplete
 *             a function to accept a completion notification from the Publisher.
 * @return a [Disposable] reference with which the caller can stop receiving items before
 *         the Publisher has finished sending them.
 * @see Either.fold
 */
fun <L, R> Flowable<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit = {},
    ifRight: (R) -> Unit = {},
    ifComplete: () -> Unit = {}
): Disposable = this.subscribeBy(
    onNext = { it.fold(ifLeft, ifRight) },
    onComplete = { ifComplete() },
    onError = { it.printStackTrace() }
)
