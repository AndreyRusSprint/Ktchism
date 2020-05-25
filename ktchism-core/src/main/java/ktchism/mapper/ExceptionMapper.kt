package ktchism.mapper

import ktchism.exception.Failure

interface ExceptionMapper {
    fun transform(from: Throwable): Failure = Failure.UnexpectedError
}
