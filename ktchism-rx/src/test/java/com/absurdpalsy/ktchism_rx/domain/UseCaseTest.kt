package com.absurdpalsy.ktchism_rx.domain

import com.absurdpalsy.ktchism_rx.domain.interactor.UseCase
import io.reactivex.observers.TestObserver
import org.junit.Test

abstract class UseCaseTest<Result, Params> {
    protected abstract val useCase: UseCase<Result, Params>

    protected abstract var params: Params

    protected abstract fun buildTestObservable(): TestObserver<Result>

    @Test
    abstract fun `Invoke use case - if success - return result`()

    @Test
    abstract fun `Invoke use case - if failure - return exception`()
}
