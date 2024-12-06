import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

val DependencyHandlerScope.coreDiModule: ProjectDependency
    get() = project(Module.Core.Di.key)

val DependencyHandlerScope.coreNetworkModule: ProjectDependency
    get() = project(Module.Core.Network.key)

val DependencyHandlerScope.homeDataModule: ProjectDependency
    get() = project(Module.Home.Data.key)

val DependencyHandlerScope.homeDomainModule: ProjectDependency
    get() = project(Module.Home.Domain.key)

val DependencyHandlerScope.homePresentationModule: ProjectDependency
    get() = project(Module.Home.Presentation.key)

fun DependencyHandler.useModules(vararg module: ProjectDependency) {
    module.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.useApiModules(vararg module: ProjectDependency) {
    module.forEach {
        add("api", it)
    }
}