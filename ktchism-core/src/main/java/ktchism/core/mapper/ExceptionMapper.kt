package ktchism.core.mapper

import ktchism.core.exception.Failure

interface ExceptionMapper {
    fun transform(from: Throwable): Failure = Failure.UnexpectedError
}
