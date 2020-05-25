package ktchism.interactor

import ktchism.UnitTest
import org.junit.Assert.assertEquals
import org.junit.Test

abstract class UseCaseTest<Result, Params> : UnitTest() {

    protected abstract val useCase: UseCase<Result, Params>

    protected abstract val params: Params

    protected abstract val result: Result

    @Test
    open fun `Invoke use case - return correct result`() {
        val actual = useCase(params)
        assertEquals(result, actual)
    }
}
