package ktchism.rx.useCase

import io.reactivex.Flowable
import ktchism.core.UseCase

interface UseCaseFlowable<Result, in Params> : UseCase<Flowable<Result>, Params>
    where Result : Any, Params : UseCase.Params
