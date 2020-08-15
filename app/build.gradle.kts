apply plugin: 'com.android.application'

apply from: "${rootDir.absolutePath}/modules/android_partial.gradle"

apply from: "${rootDir.absolutePath}/modules/test_partial.gradle"

apply from: "${rootDir.absolutePath}/modules/lint_partial.gradle"

android {
    defaultConfig {
        applicationId "com.yt8492.qiitaclient"
    }
}

dependencies {
    implementation project(":modules:api")
}