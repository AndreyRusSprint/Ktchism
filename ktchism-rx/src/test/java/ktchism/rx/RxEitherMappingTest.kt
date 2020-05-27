package ktchism.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.functional.Either
import org.junit.Test

class RxEitherMappingTest {

    @Test
    fun `Observable flatMapEither - flatMap value`() {
        val either: Either<String, Int> = Either.right(5)
        val observable = Observable.just(either)

        val fn: (Int) -> Either<String, String> = {
            Either.right(it.toString())
        }

        val expectedValue: Either<String, String> = Either.right("5")

        observable.flatMapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Single flatMapEither - flatMap value`() {
        val either: Either<String, Int> = Either.right(5)
        val single = Single.just(either)

        val fn: (Int) -> Either<String, String> = {
            Either.right(it.toString())
        }

        val expectedValue: Either<String, String> = Either.right("5")

        single.flatMapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Flowable flatMapEither - flatMap value`() {
        val either: Either<String, Int> = Either.right(5)
        val flowable = Flowable.just(either)

        val fn: (Int) -> Either<String, String> = {
            Either.right(it.toString())
        }

        val expectedValue: Either<String, String> = Either.right("5")

        flowable.flatMapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Observable mapEither - map right either value`() {
        val either: Either<String, Int> = Either.right(5)
        val observable = Observable.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.right("5")

        observable.mapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Single mapEither - map right either value`() {
        val either: Either<String, Int> = Either.right(5)
        val single = Single.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.right("5")

        single.mapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Flowable mapEither - map right either value`() {
        val either: Either<String, Int> = Either.right(5)
        val flowable = Flowable.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.right("5")

        flowable.mapEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Observable mapLeftEither - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val observable = Observable.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.left("5")

        observable.mapLeftEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Single mapLeftEither - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val single = Single.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.left("5")

        single.mapLeftEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Flowable mapLeftEither - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val flowable = Flowable.just(either)

        val fn: (Int) -> String = { it.toString() }

        val expectedValue: Either<String, String> = Either.left("5")

        flowable.mapLeftEither(fn)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Observable bimapEither - if Left - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val observable = Observable.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.left("5")

        observable.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Observable bimapEither - if Right - map right either value`() {
        val either: Either<Int, String> = Either.right("5")
        val observable = Observable.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.right(5)

        observable.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Single bimapEither - if Left - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val single = Single.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.left("5")

        single.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Single bimapEither - if Right - map right either value`() {
        val either: Either<Int, String> = Either.right("5")
        val single = Single.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.right(5)

        single.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Flowable bimapEither - if Left - map left either value`() {
        val either: Either<Int, String> = Either.left(5)
        val flowable = Flowable.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.left("5")

        flowable.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }

    @Test
    fun `Flowable bimapEither - if Right - map right either value`() {
        val either: Either<Int, String> = Either.right("5")
        val flowable = Flowable.just(either)

        val fnL: (Int) -> String = { it.toString() }
        val fnR: (String) -> Int = { it.toInt() }

        val expectedValue: Either<String, Int> = Either.right(5)

        flowable.bimapEither(fnL, fnR)
            .test()
            .assertValue(expectedValue)
            .dispose()
    }
}
