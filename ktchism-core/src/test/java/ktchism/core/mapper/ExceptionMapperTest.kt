package ktchism.core.mapper

import ktchism.UnitTest
import ktchism.core.exception.Failure
import org.junit.Assert.assertEquals
import org.junit.Test

abstract class ExceptionMapperTest : UnitTest() {

    protected abstract val mapper: ExceptionMapper

    protected abstract val exception: Throwable

    protected abstract val failure: Failure

    @Test
    fun `Transform exception must return correct failure`() {
        val actual = mapper.transform(exception)
        assertEquals(failure, actual)
    }
}
