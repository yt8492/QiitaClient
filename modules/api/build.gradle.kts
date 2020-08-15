apply plugin: 'com.android.library'

apply from: "${rootDir.absolutePath}/modules/android_partial.gradle"

apply from: "${rootDir.absolutePath}/modules/test_partial.gradle"

apply from: "${rootDir.absolutePath}/modules/lint_partial.gradle"

android {
    defaultConfig {
        buildConfigField("String", "QIITA_URL", "\"https://qiita.com\"")
    }
}
