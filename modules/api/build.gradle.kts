plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("org.jlleitschuh.gradle.ktlint")
}

androidCommon()
android {
    defaultConfig {
        buildConfigField("String", "QIITA_URL", "\"https://qiita.com\"")
    }
}

dependencies {
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
