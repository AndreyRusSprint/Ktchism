package ktchism.rx

import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either
import org.junit.Test

class RxEitherTest {

    private val error = mock<Throwable>()

    @Test
    fun `Observable to Either - if success - return Right`() {
        val observable = Observable.just(3)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        observable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Observable to Either - if failure - return Left`() {
        val observable = Observable.error<Int>(error)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        observable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Single to Either - if success - return Right`() {
        val single = Single.just(3)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        single.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Single to Either - if failure - return Left`() {
        val single = Single.error<Int>(error)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        single.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Flowable to Either - if success - return Right`() {
        val flowable = Flowable.just(3)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        flowable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Flowable to Either - if failure - return Left`() {
        val flowable = Flowable.error<Int>(error)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        flowable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }
}
