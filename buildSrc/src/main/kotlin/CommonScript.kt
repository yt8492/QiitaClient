import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.TestedExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

private fun Project.androidExt(configure: TestedExtension.() -> Unit) {
    (this as ExtensionAware).extensions.configure("android", configure)
}

fun Project.androidCommon() {
    androidExt {
        compileSdkVersion(Android.compileSdk)
        buildToolsVersion = Android.buildTools
        aaptOptions.cruncherEnabled = false

        defaultConfig {
            minSdkVersion(Android.minSdk)
            targetSdkVersion(Android.targetSdk)
            versionCode = Android.versionCode
            versionName = Android.versionName
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
        if (this is BaseAppModuleExtension) {
            buildFeatures {
                dataBinding = true
            }
        } else if (this is LibraryExtension) {
            buildFeatures {
                dataBinding = true
            }
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
        packagingOptions {
            exclude("META-INF/LICENSE.md")
            exclude("META-INF/main.kotlin_module")
            exclude("META-INF/metadata.kotlin_module")
            exclude("META-INF/metadata.jvm.kotlin_module")
            exclude("META-INF/LICENSE-notice.md")
        }
    }
}
