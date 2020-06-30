package ktchism.rx.useCase

import io.reactivex.Single
import ktchism.core.UseCase

/**
 * [UseCase] with [Single] result.
 *
 * @param Result the type of the item emitted by the [Single].
 * @param Params the type of input parameters.
 */
interface UseCaseSingle<Result, in Params> : UseCase<Single<Result>, Params>
    where Result : Any, Params : UseCase.Params
