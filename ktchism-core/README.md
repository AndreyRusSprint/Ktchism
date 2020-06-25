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
