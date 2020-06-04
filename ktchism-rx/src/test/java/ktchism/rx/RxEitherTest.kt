package ktchism.rx

import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.exception.Failure
import ktchism.core.functional.Either
import ktchism.core.mapper.ExceptionMapper
import org.junit.Test

class RxEitherTest {

    private val error = mock<Throwable>()

    @Test
    fun `Observable to Either - if success - return Right (lambda mapper)`() {
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
    fun `Observable to Either - if success - return Right (base mapper)`() {
        val observable = Observable.just(3)
        val exceptionMapper = object : ExceptionMapper {}

        observable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Observable to Either - if failure - return Left (lambda mapper)`() {
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
    fun `Observable to Either - if failure - return Left (base mapper)`() {
        val observable = Observable.error<Int>(error)
        val exceptionMapper = object : ExceptionMapper {}

        observable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Single to Either - if success - return Right (lambda mapper)`() {
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
    fun `Single to Either - if success - return Right (base mapper)`() {
        val single = Single.just(3)
        val exceptionMapper = object : ExceptionMapper {}

        single.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Single to Either - if failure - return Left (lambda mapper)`() {
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
    fun `Single to Either - if failure - return Left (base mapper)`() {
        val single = Single.error<Int>(error)
        val exceptionMapper = object : ExceptionMapper {}

        single.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Flowable to Either - if success - return Right (lambda mapper)`() {
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
    fun `Flowable to Either - if success - return Right (base mapper)`() {
        val flowable = Flowable.just(3)
        val exceptionMapper = object : ExceptionMapper {}

        flowable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Int> }
            .dispose()
    }

    @Test
    fun `Flowable to Either - if failure - return Left (lambda mapper)`() {
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

    @Test
    fun `Flowable to Either - if failure - return Left (base mapper)`() {
        val flowable = Flowable.error<Int>(error)
        val exceptionMapper = object : ExceptionMapper {}

        flowable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Completable to Either - if complete - return Right (lambda mapper)`() {
        val completable = Completable.complete()
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        completable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Unit> }
            .dispose()
    }

    @Test
    fun `Completable to Either - if complete - return Right (base mapper)`() {
        val completable = Completable.complete()
        val exceptionMapper = object : ExceptionMapper {}

        completable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Right<Unit> }
            .dispose()
    }

    @Test
    fun `Completable to Either - if failure - return Left (lambda mapper)`() {
        val completable = Completable.error(error)
        val exceptionMapper: (Throwable) -> Failure = {
            Failure.UnexpectedError
        }

        completable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }

    @Test
    fun `Completable to Either - if failure - return Left (base mapper)`() {
        val completable = Completable.error(error)
        val exceptionMapper = object : ExceptionMapper {}

        completable.toEither(exceptionMapper)
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValue { it is Either.Left<Failure> }
            .dispose()
    }
}
