package ktchism.rx.useCase

import io.reactivex.Observable
import ktchism.core.UseCase

interface UseCaseObservable<Result, in Params> : UseCase<Observable<Result>, Params>
    where Result : Any, Params : UseCase.Params
