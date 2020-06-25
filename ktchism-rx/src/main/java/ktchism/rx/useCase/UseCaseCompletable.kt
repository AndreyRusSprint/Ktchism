package ktchism.rx.useCase

import io.reactivex.Completable
import ktchism.core.UseCase

interface UseCaseCompletable<in Params> : UseCase<Completable, Params>
    where Params : UseCase.Params
