package ktchism.rx.useCase

import io.reactivex.Completable
import ktchism.core.UseCase

/**
 * [UseCase] with [Completable] result.
 *
 * @param Params the type of input parameters.
 */
interface UseCaseCompletable<in Params> : UseCase<Completable, Params>
    where Params : UseCase.Params
