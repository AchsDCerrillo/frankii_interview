import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

sealed class Module(
    val namespace: String,
    val key: String,
) {
    object Core {
        object Di : Module(
            namespace = "com.alexce.frankichallenge.core.di",
            key = ":core:di"
        )
        object Network : Module(
            namespace = "com.alexce.frankichallenge.core.network",
            key = ":core:network"
        )
    }
    object Home {
        object Data : Module(
            namespace = "com.alexce.frankichallenge.home.data",
            key = ":home:data"
        )
        object Domain : Module(
            namespace = "com.alexce.frankichallenge.home.domain",
            key = ":home:domain"
        )
        object Presentation : Module(
            namespace = "com.alexce.frankichallenge.home.presentation",
            key = ":home:presentation"
        )
    }
}