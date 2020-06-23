package ktchism.core.exception

/**
 * Base class for handling errors.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object NotFound : Failure()
    object Unauthorized : Failure()
    object DataStoreError : Failure()
    object UnexpectedError : Failure()

    /**
     * Feature specific failure.
     */
    abstract class FeatureFailure : Failure()
}
