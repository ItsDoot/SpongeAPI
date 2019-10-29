val name: String by settings
rootProject.name = name

pluginManagement {
    repositories {
        jcenter()
        mavenLocal()
        mavenCentral()
        maven("https://repo.spongepowered.org/maven")
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("org.spongepowered.gradle.")) {
                val version = requested.version ?: "0.11.0-SNAPSHOT"
                useModule("org.spongepowered:spongegradle:$version")
            }
        }
    }
}
