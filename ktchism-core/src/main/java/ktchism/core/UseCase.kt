package ktchism.core

/**
 * Describes an application use case.
 *
 * @param Result the type of result of execution.
 * @param Params the type of input parameters.
 */
interface UseCase<out Result, in Params> where Result : Any, Params : UseCase.Params {

    /**
     * Execute use case.
     *
     * @param params input parameters.
     * @return result of execution.
     */
    operator fun invoke(params: Params): Result

    /**
     * Marker interface for input parameters.
     */
    interface Params

    /**
     * Default (empty) parameters.
     */
    object None : Params
}
