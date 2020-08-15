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
}

ktlint {
    version.set("0.22.0")
    android.set(true)
    ignoreFailures.set(true)
}
