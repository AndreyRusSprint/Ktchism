package ktchism.core

interface UseCase<out Result, in Params> where Result : Any, Params : UseCase.Params {

    operator fun invoke(params: Params): Result

    interface Params

    object None : Params
}
