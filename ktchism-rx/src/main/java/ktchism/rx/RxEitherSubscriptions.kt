package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import ktchism.core.functional.Either

fun <L, R> Observable<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit,
    ifRight: (R) -> Unit,
    ifComplete: () -> Unit
): Disposable = this.subscribeBy(
    onNext = { it.fold(ifLeft, ifRight) },
    onComplete = { ifComplete() },
    onError = { it.printStackTrace() }
)

fun <L, R> Single<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit,
    ifRight: (R) -> Unit
): Disposable = this.subscribeBy(
    onSuccess = { it.fold(ifLeft, ifRight) },
    onError = { it.printStackTrace() }
)

fun <L, R> Flowable<Either<L, R>>.foldSubscribe(
    ifLeft: (L) -> Unit,
    ifRight: (R) -> Unit,
    ifComplete: () -> Unit
): Disposable = this.subscribeBy(
    onNext = { it.fold(ifLeft, ifRight) },
    onComplete = { ifComplete() },
    onError = { it.printStackTrace() }
)
