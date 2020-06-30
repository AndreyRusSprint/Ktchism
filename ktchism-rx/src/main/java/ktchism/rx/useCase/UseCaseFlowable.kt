package ktchism.rx.useCase

import io.reactivex.Flowable
import ktchism.core.UseCase

/**
 * [UseCase] with [Flowable] result.
 *
 * @param Result the type of the items emitted by the [Flowable].
 * @param Params the type of input parameters.
 */
interface UseCaseFlowable<Result, in Params> : UseCase<Flowable<Result>, Params>
    where Result : Any, Params : UseCase.Params
