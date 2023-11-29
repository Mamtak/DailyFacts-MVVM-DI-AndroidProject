plugins {
    id("com.android.application")
}

android {
    namespace = "com.app.dailyfacts"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.dailyfacts"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.test:monitor:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")

    //These Are Some Common Libraries
    implementation("com.squareup.okhttp:okhttp:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.3.0")
    implementation("com.google.code.gson:gson:2.8.2")
    implementation("com.squareup.retrofit2:retrofit:2.3.0")
    implementation("io.reactivex.rxjava2:rxjava:2.1.9")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("com.squareup.okhttp3:logging-interceptor:3.9.1")
    //D2
    implementation("com.google.dagger:dagger-android-support:2.35.1")
    implementation("com.google.dagger:dagger:2.35.1")
    annotationProcessor("com.google.dagger:dagger-compiler:2.35.1")
    annotationProcessor("com.google.dagger:dagger-android-processor:2.35.1")
    //instead of check Project level build.gradle for version values
//    implementation("com.android.support:appcompat-v7:25.3.1")
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    annotationProcessor("androidx.arch.core:core-common:2.2.0")
  implementation("androidx.arch.core:core-runtime:2.2.0")
    // Annotation processor
    implementation("androidx.fragment:fragment:1.6.2")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    androidTestImplementation("org.mockito:mockito-core:5.3.1")
    testImplementation("org.mockito:mockito-core:5.3.1")
    implementation("androidx.annotation:annotation:1.7.0")
    //Splash screen
    implementation("androidx.core:core-splashscreen:1.0.0-alpha02")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.1")
}

