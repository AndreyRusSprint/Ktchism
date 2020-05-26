package ktchism.core.functional

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyZeroInteractions
import ktchism.UnitTest
import org.junit.Assert.*
import org.junit.Test

class EitherTest : UnitTest() {

    @Test
    fun `Either Left - return correct type`() {
        val value = "Failure"
        val result = Either.left(value)

        assertTrue(result.isLeft)
        assertFalse(result.isRight)
        result.fold(
            ifLeft = { assertEquals(value, it) },
            ifRight = { fail() }
        )
    }

    @Test
    fun `Either Right - return correct type`() {
        val value = "Success"
        val result = Either.right(value)

        assertTrue(result.isRight)
        assertFalse(result.isLeft)
        result.fold(
            ifLeft = { fail() },
            ifRight = { assertEquals(value, it) }
        )
    }

    @Test
    fun `Either fold - if Left - invoke first argument`() {
        val ifLeft = mock<(String) -> Unit>()
        val ifRight = mock<(String) -> Unit>()

        val value = "Failure"
        val either = Either.left(value)

        either.fold(ifLeft, ifRight)

        verify(ifLeft).invoke(value)
        verifyZeroInteractions(ifRight)
    }

    @Test
    fun `Either fold - if Right - invoke second argument`() {
        val ifLeft = mock<(String) -> Unit>()
        val ifRight = mock<(String) -> Unit>()

        val value = "Success"
        val either = Either.right(value)

        either.fold(ifLeft, ifRight)

        verify(ifRight).invoke(value)
        verifyZeroInteractions(ifLeft)
    }

    @Test
    fun `Either exists - if Left - return false`() {
        val either = Either.left("Failure")

        val predicate: (Int) -> Boolean = { true }

        val result = either.exists(predicate)
        assertFalse(result)
    }

    @Test
    fun `Either exists - if Right - apply predicate`() {
        val either = Either.right(5)

        val predicate: (Int) -> Boolean = { it > 0 }

        val result = either.exists(predicate)
        assertTrue(result)
    }

    @Test
    fun `Either flatMap - if Left - return unchanged`() {
        val fn = mock<(Int) -> Either<Int, String>>()

        val value = -1
        val either: Either<Int, Int> = Either.left(value)

        val result = either.flatMap(fn)

        verifyZeroInteractions(fn)
        assertEquals(either, result)
    }

    @Test
    fun `Either flatMap - if Right - apply function`() {
        val expectedResult = Either.right(30)
        val either = Either.right(6)

        val result = either.flatMap { Either.right(it * 5) }

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Either map - if Left - return unchanged`() {
        val fn: (Int) -> String = mock()

        val either = Either.left(-1)

        val result = either.map(fn)

        verifyZeroInteractions(fn)
        assertEquals(either, result)
    }

    @Test
    fun `Either map - if Right - apply function`() {
        val fn: (Int) -> String = { it.toString() }

        val either = Either.right(5)

        val expectedResult = Either.right("5")
        val result = either.map(fn)

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Either mapLeft - if Left - apply function`() {
        val fn: (Int) -> String = { it.toString() }

        val either = Either.left(1)

        val expectedResult = Either.left("1")
        val result = either.mapLeft(fn)

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Either mapLeft - if Right - return unchanged`() {
        val fn: (Int) -> String = mock()

        val either = Either.right(1)

        val result = either.mapLeft(fn)

        verifyZeroInteractions(fn)
        assertEquals(either, result)
    }

    @Test
    fun `Either bimap - if Left - apply left function`() {
        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = mock()

        val either: Either<Int, String> = Either.left(5)

        val expectedResult: Either<String, Int> = Either.left("5")
        val result = either.bimap(fnL, fnR)

        verifyZeroInteractions(fnR)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Either bimap - if Right - apply right function`() {
        val fnL: (Int) -> String = mock()
        val fnR: (String) -> Int = { it.toInt() }

        val either: Either<Int, String> = Either.right("5")

        val expectedResult: Either<String, Int> = Either.right(5)
        val result = either.bimap(fnL, fnR)

        verifyZeroInteractions(fnL)
        assertEquals(expectedResult, result)
    }

    @Test
    fun `Either getOrElse - if Left - return default value`() {
        val either: Either<Int, String> = Either.left(5)
        val defaultValue = "Default"

        val result = either.getOrElse(defaultValue)

        assertEquals(defaultValue, result)
    }

    @Test
    fun `Either getOrElse - if Right - return value`() {
        val either: Either<Int, Int> = Either.right(5)
        val defaultValue = 3

        val result = either.getOrElse(defaultValue)

        assertEquals(5, result)
    }
}
