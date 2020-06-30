# Ktchism-rx

Reactive extensions for the [Ktchism-core](https://github.com/AndreyRusSprint/Ktchism/tree/dev/ktchism-core).

## Reactive UseCase

Complex of interfaces extending the base `UseCase` wrapping the result in observable sequences.

### UseCaseObservable

Use case which result is `Observable`.

```kotlin
class GetUsers : UseCaseObservable<User, UseCase.None> {
    override fun invoke(params: UseCase.None): Observable<User> {
        // implementation details...
    }
}
```

### UseCaseSingle

Use case which result is `Single`.

```kotlin
class GetUser : UseCaseSingle<User, UseCase.None> {
    override fun invoke(params: UseCase.None): Single<User> {
        // implementation details...
    }
}
```

### UseCaseCompletable

Use case which result is `Completable`.

```kotlin
class LogOut : UseCaseCompletable<UseCase.None> {
    override fun invoke(params: UseCase.None): Completable {
        // implementation details...
    }
}
```

### UseCaseFlowable

Use case which result is `Flowable`.

```kotlin
class GetUsers : UseCaseFlowable<User, UseCase.None> {
    override fun invoke(params: UseCase.None): Flowable<User> {
        // implementation details...
    }
}
```

## RxEither

Extension functions for wrapping observable sequence items in `Either`.

For example:

```kotlin
val source: Observable<Int> = Observable.just(1, 2, 3)
val exceptionMapper: (Throwable) -> Failure = { Failure.UnexpectedError }
val resultSource: Observable<Either<Failure, Int>> = source.toEither(exceptionMapper)
```

## Transformations

Extension functions for applying `Either` specific transforming functions directly to `Either` wrapped
in a observable sequence.

For example:

```kotlin
val source: Observable<Either<Failure, Int>> = Observable.just(
    Either.right(1),
    Either.right(2),
    Either.right(3)
)
val resultingSource = source.mapEither { it * 2 } // Either.right(1), Either.right(4), Either.right(6)
```

## Subscriptions

Extension functions to simplify handling items from observable sequence containing `Either`.

For example:

```kotlin
val source: Observable<Either<Failure, Int>> = Observable.just(
    Either.right(1),
    Either.right(2),
    Either.left(Failure.NetworkConnection),
    Either.right(3)
)
source.foldSubscribe(
    ifLeft = { println("Error: $it") },
    ifRight = { println("Value: $it") },
    ifComplete = { println("Complete") }
)
// Value: 1
// Value: 2
// Error: NetworkConnection
// Value: 3
// Complete
```
