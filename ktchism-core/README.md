# Ktchism-core

[ ![Bintray](https://api.bintray.com/packages/absurdpalsy/Maven/ktchism-core/images/download.svg) ](https://bintray.com/absurdpalsy/Maven/ktchism-core/_latestVersion)

The main components of architecture.

## Use Case

Interface that describes an application use case.

To use, implement an interface in your class with business logic by providing
input and output parameters.

```kotlin
class GetUsers : UseCase<List<User>, UseCase.None> {
    override fun invoke(params: UseCase.None): List<User> {
        // implementation details...
    }
}
```
If you need to pass any input parameters, create a class with the necessary
parameters that implement `UseCase.Params` interface.

```kotlin
class GetUser : UseCase<User, GetUser.Params> {
    override fun invoke(params: GetUser.Params): User {
        // implementation details...
    }

    class Params(val id: Int): UseCase.Params
}
```

`UseCase` can be used as function.

```kotlin
class UserPresenter(private val getUser: GetUser) {
    fun loadUser(id: Int) {
        val params = GetUser.Params(id)
        val user = getUser(params)
    }
}
```

## Failure

Sealed class that describes domain specific errors.

This class is intended to replace exceptions.
By default it includes the most common errors, but if necessary, you can add your own by extending
`FeatureFailure` abstract class.

## Exception mapper

Base interface for mapper that map errors and exceptions to `Failure`.

```kotlin
class FeatureSpecificExceptionMapper : ExceptionMapper {
    override fun transform(from: Throwable): Failure = when (from) {
        is ConnectException -> Failure.NetworkConnection()
        else -> super(from)
    }
}
```

## Either

Represents a value of one of two possible types (a disjoint union).

Instances of `Either` are either an instance of `Left` or `Right`.
FP Convention dictates that `Left` is used for "failure"
and `Right` is used for "success".

[Read more...](https://hackage.haskell.org/package/category-extras-0.52.0/docs/Control-Monad-Either.html)
