package ktchism.interactor

abstract class UseCase<out Result, in Params> where Result : Any {

    operator fun invoke(params: Params): Result = constructResult(params)

    protected abstract fun constructResult(params: Params): Result

    class None
}
