fun url(s: String) {

}

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven {
            url = uri("https://jcenter.bintray.com")
        }
        maven {
            url = uri("https://jitpack.io")
        }
        jcenter()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jcenter.bintray.com")
        }
        maven {
            url = uri("https://jitpack.io")
        }
        jcenter()
    }
}

rootProject.name = "Project"
include(":app")
