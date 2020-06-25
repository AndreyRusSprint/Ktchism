package ktchism.rx

import io.reactivex.Scheduler
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

open class RxImmediateSchedulerRule(
    private val scheduler: Scheduler = Schedulers.trampoline()
) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement =
        object : Statement() {
            override fun evaluate() {
                setSchedulerHandler(scheduler)

                try {
                    base?.evaluate()
                } finally {
                    reset()
                }
            }
        }

    protected open fun setSchedulerHandler(scheduler: Scheduler) {
        RxJavaPlugins.setIoSchedulerHandler { scheduler }
        RxJavaPlugins.setComputationSchedulerHandler { scheduler }
        RxJavaPlugins.setNewThreadSchedulerHandler { scheduler }
    }

    protected open fun reset() {
        RxJavaPlugins.reset()
    }
}
