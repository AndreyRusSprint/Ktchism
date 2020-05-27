package ktchism.rx

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import ktchism.core.functional.Either
import org.junit.Test

class RxEitherSubscriptionsTest {

    @Test
    fun `Observable fold subscribe - if Left - invoke left fn on next`() {
        val either: Either<Int, String> = Either.left(5)
        val observable = Observable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        observable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifLeft).invoke(5)
    }

    @Test
    fun `Observable fold subscribe - if Right - invoke right fn on next`() {
        val value = "Test"
        val either: Either<Int, String> = Either.right(value)
        val observable = Observable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        observable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifRight).invoke(value)
    }

    @Test
    fun `Observable fold subscribe - invoke complete fn on complete`() {
        val either: Either<Int, String> = Either.left(5)
        val observable = Observable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        observable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifComplete).invoke()
    }

    @Test
    fun `Single fold subscribe - if Left - invoke left fn on success`() {
        val either: Either<Int, String> = Either.left(5)
        val single = Single.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()

        single.foldSubscribe(ifLeft, ifRight)
            .dispose()

        verify(ifLeft).invoke(5)
    }

    @Test
    fun `Single fold subscribe - if Right - invoke right fn on success`() {
        val value = "Test"
        val either: Either<Int, String> = Either.right(value)
        val single = Single.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()

        single.foldSubscribe(ifLeft, ifRight)
            .dispose()

        verify(ifRight).invoke(value)
    }

    @Test
    fun `Flowable fold subscribe - if Left - invoke left fn on next`() {
        val either: Either<Int, String> = Either.left(5)
        val flowable = Flowable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        flowable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifLeft).invoke(5)
    }

    @Test
    fun `Flowable fold subscribe - if Right - invoke right fn on next`() {
        val value = "Test"
        val either: Either<Int, String> = Either.right(value)
        val flowable = Flowable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        flowable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifRight).invoke(value)
    }

    @Test
    fun `Flowable fold subscribe - invoke complete fn on complete`() {
        val either: Either<Int, String> = Either.left(5)
        val flowable = Flowable.just(either)

        val ifLeft: (Int) -> Unit = mock()
        val ifRight: (String) -> Unit = mock()
        val ifComplete: () -> Unit = mock()

        flowable.foldSubscribe(ifLeft, ifRight, ifComplete)
            .dispose()

        verify(ifComplete).invoke()
    }
}
