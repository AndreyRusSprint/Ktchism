package ktchism.rx.useCase

import io.reactivex.Single
import ktchism.core.UseCase

interface UseCaseSingle<Result, in Params> : UseCase<Single<Result>, Params>
    where Result : Any, Params : UseCase.Params
