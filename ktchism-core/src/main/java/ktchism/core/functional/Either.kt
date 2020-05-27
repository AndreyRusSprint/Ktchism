package ktchism.core.functional

import ktchism.core.functional.Either.Companion.right
import ktchism.core.functional.Either.Left
import ktchism.core.functional.Either.Right

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 */
sealed class Either<out L, out R> {

    /**
     * Represents the left side of [Either] class which by convention is a "Failure".
     */
    data class Left<out L>(val value: L) : Either<L, Nothing>()

    /**
     * Represents the right side of [Either] class which by convention is a "Success".
     */
    data class Right<out R>(val value: R) : Either<Nothing, R>()

    /**
     * Returns true if this is a [Right], false otherwise.
     */
    val isRight: Boolean
        get() = this is Right<R>

    /**
     * Returns true if this is a [Left], false otherwise.
     */
    val isLeft: Boolean
        get() = this is Left<L>

    companion object {
        /**
         * Creates a [Left] type.
         */
        fun <L> left(value: L): Either<L, Nothing> = Left(value)

        /**
         * Creates a [Right] type.
         */
        fun <R> right(value: R): Either<Nothing, R> = Right(value)
    }

    /**
     * Applies [ifLeft] if this is a [Left] or [ifRight] if this is a [Right].
     *
     * @param ifLeft the function to apply if this is a [Left]
     * @param ifRight the function to apply if this is a [Right]
     * @return the results of applying the function
     */
    inline fun <T> fold(ifLeft: (L) -> T, ifRight: (R) -> T): T =
        when (this) {
            is Left -> ifLeft(value)
            is Right -> ifRight(value)
        }

    /**
     * Returns `false` if [Left] or returns the result of the application of
     * the given predicate to the [Right] value.
     */
    fun exists(predicate: (R) -> Boolean): Boolean =
        fold({ false }, { predicate(it) })
}

/**
 * Composes 2 functions
 */
fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

/**
 * Right-biased flatMap().
 *
 * The given function is applied if this is a [Right].
 */
fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Left -> this
        is Right -> fn(value)
    }

/**
 * The given function is applied if this is a [Right].
 */
fun <T, L, R> Either<L, R>.map(fn: (R) -> T): Either<L, T> =
    this.flatMap(fn.c(::right))

/**
 * The given function is applied if this is a [Left].
 */
fun <T, L, R> Either<L, R>.mapLeft(fn: (L) -> T): Either<T, R> =
    fold({ Left(fn(it)) }, { Right(it) })

/**
 * Map over [Left] and [Right] of this [Either].
 */
fun <T, E, L, R> Either<L, R>.bimap(fnL: (L) -> E, fnR: (R) -> T): Either<E, T> =
    fold({ Left(fnL(it)) }, { Right(fnR(it)) })

/**
 * Returns the value from this [Right] or the given argument if this is a [Left].
 */
fun <L, R> Either<L, R>.getOrElse(defaultValue: R): R =
    when (this) {
        is Left -> defaultValue
        is Right -> value
    }
