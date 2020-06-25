package ktchism.core.mapper

import ktchism.core.exception.Failure

/**
 * Base interface for mapper that map errors and exceptions to [Failure].
 */
interface ExceptionMapper {
    /**
     * Transform error or exception to [Failure].
     * Return [Failure.UnexpectedError] by default.
     *
     * @param from error or exception to be transformed.
     * @return [Failure].
     *
     */
    fun transform(from: Throwable): Failure = Failure.UnexpectedError
}
