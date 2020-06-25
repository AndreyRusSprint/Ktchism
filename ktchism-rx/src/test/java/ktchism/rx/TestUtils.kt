package ktchism.rx

import io.reactivex.disposables.Disposable
import io.reactivex.observers.TestObserver

fun <T> TestObserver<T>.successful(): Disposable = this
    .assertComplete()
    .assertNoErrors()

fun <T> TestObserver<T>.successful(expectedValue: T): Disposable = this
    .assertComplete()
    .assertNoErrors()
    .assertValue(expectedValue)

fun <T> TestObserver<T>.successful(predicate: (T) -> Boolean): Disposable = this
    .assertComplete()
    .assertNoErrors()
    .assertValue(predicate)

fun <T> TestObserver<T>.failure(expectedError: Throwable): Disposable = this
    .assertNotComplete()
    .assertError(expectedError)

fun <T> TestObserver<T>.failure(expectedError: Class<out Throwable>): Disposable = this
    .assertNotComplete()
    .assertError(expectedError)

