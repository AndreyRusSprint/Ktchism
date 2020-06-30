package ktchism.rx.useCase

import io.reactivex.Observable
import ktchism.core.UseCase

/**
 * [UseCase] with [Observable] result.
 *
 * @param Result the type of the items emitted by the [Observable].
 * @param Params the type of input parameters.
 */
interface UseCaseObservable<Result, in Params> : UseCase<Observable<Result>, Params>
    where Result : Any, Params : UseCase.Params
