package com.absurdpalsy.ktchism_rx.common

import com.absurdpalsy.ktchism_rx.domain.exception.Failure
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

fun <T> Observable<T>.defaultSubscribeBy(
    onNext: (T) -> Unit = {},
    onError: (Failure) -> Unit = {},
    onComplete: () -> Unit = {}
): Disposable = subscribe(onNext, { exception ->
    onError(exception as? Failure ?: Failure.UnexpectedError)
}, onComplete)

fun <T> Single<T>.defaultSubscribeBy(
    onSuccess: (T) -> Unit = {},
    onError: (Failure) -> Unit = {}
): Disposable = subscribe(onSuccess, { exception ->
    onError(exception as? Failure ?: Failure.UnexpectedError)
})

fun Completable.defaultSubscribeBy(
    onComplete: () -> Unit = {},
    onError: (Failure) -> Unit = {}
): Disposable = subscribe(onComplete, { exception ->
    onError(exception as? Failure ?: Failure.UnexpectedError)
})
