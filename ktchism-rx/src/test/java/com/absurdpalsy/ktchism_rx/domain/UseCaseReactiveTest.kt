package com.absurdpalsy.ktchism_rx.domain

import io.reactivex.observers.TestObserver
import org.junit.Test

abstract class UseCaseReactiveTest<Result, Params> {

    protected abstract var params: Params
    protected abstract var resultValue: Result
    protected abstract var error: Throwable

    protected abstract fun buildUseCaseObserver(params: Params): TestObserver<Result>

    @Test
    open fun `Invoke use case - if success - return result`() {
        buildUseCaseObserver(params)
            .assertComplete()
            .assertNoErrors()
            .assertValue(resultValue)
            .dispose()
    }

    @Test
    open fun `Invoke use case - if failure - return error`() {
        buildUseCaseObserver(params)
            .assertNotComplete()
            .assertError(error)
            .dispose()
    }
}
