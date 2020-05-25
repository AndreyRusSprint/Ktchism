package com.absurdpalsy.ktchism_rx.domain.exception

sealed class Failure : Exception() {
    object NetworkConnection : Failure()
    object NotFound : Failure()
    object Unauthorized : Failure()
    object ServerError : Failure()
    object UnexpectedError : Failure()

    abstract class FeatureFailure: Failure()
}
