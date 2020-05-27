package ktchism.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object NotFound : Failure()
    object Unauthorized : Failure()
    object DataStoreError : Failure()
    object UnexpectedError : Failure()

    abstract class FeatureFailure : Failure()
}
