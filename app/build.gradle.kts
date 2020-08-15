plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("org.jlleitschuh.gradle.ktlint")
}

androidCommon()
android {
    defaultConfig {
        applicationId = "com.yt8492.qiitaclient"
    }
}

dependencies {
    implementation(project(":modules:api"))
    implementation(Deps.Kotlin.jdk8)
    implementation(Deps.KotlinX.Coroutines.core)
    implementation(Deps.KotlinX.Coroutines.android)
    implementation(Deps.AndroidX.Appcompat.appcompat)
    implementation(Deps.AndroidX.Core.ktx)
    implementation(Deps.AndroidX.Fragment.ktx)
    implementation(Deps.AndroidX.Paging.runtime)
    implementation(Deps.AndroidX.Lifecycle.extensions)
    implementation(Deps.AndroidX.Lifecycle.liveDataKtx)
    implementation(Deps.AndroidX.Lifecycle.viewModelKtx)
    implementation(Deps.AndroidX.Browser.browser)
    implementation(Deps.Dagger.dagger)
    implementation(Deps.Dagger.androidSupport)
    kapt(Deps.Dagger.compiler)
    kapt(Deps.Dagger.androidProcessor)
    implementation(Deps.Moshi.moshi)
    implementation(Deps.Moshi.adapters)
    implementation(Deps.Moshi.kotlin)
    implementation(Deps.Moshi.kotlinCodeGen)
    implementation(Deps.Retrofit.retrofit)
    implementation(Deps.Retrofit.converterMoshi)
    implementation(Deps.Picasso.picasso)

    testImplementation(Deps.Kotlin.refrect)
    testImplementation(Deps.KotlinX.Coroutines.test)
    testImplementation(Deps.JUnit.junit)
    testImplementation(Deps.Spek.dslJvm)
    testImplementation(Deps.Spek.runnerJUnit5)
    testImplementation(Deps.MockK.mockk)
    testImplementation(Deps.Truth.truth)

    androidTestImplementation(Deps.AndroidX.Test.Runner.runnner)
    androidTestImplementation(Deps.AndroidX.Test.Espresso.core)
}

ktlint {
    version.set("0.22.0")
    android.set(true)
    ignoreFailures.set(true)
}
