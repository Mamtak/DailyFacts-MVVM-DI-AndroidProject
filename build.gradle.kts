// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.4" apply false
}
repositories {
    google()
    maven {
        url("https://maven.google.com")
    }
}

fun MavenArtifactRepository.url(s: String) {

}
