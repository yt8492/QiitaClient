object Deps {
    object Kotlin {
        const val version = "1.3.72"
        const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val refrect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object KotlinX {
        object Coroutines {
            const val version = "1.3.8"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:4.0.1"
    }

    object AndroidX {
        object Appcompat {
            const val version = "1.1.0"
            const val appcompat = "androidx.appcompat:appcompat:$version"
        }

        object Core {
            const val version = "1.2.0-alpha04"
            const val ktx = "androidx.core:core-ktx:$version"
        }

        object Fragment {
            const val version = "1.2.0-alpha04"
            const val ktx = "androidx.fragment:fragment-ktx:$version"
        }

        object Paging {
            const val version = "2.1.0"
            const val runtime = "androidx.paging:paging-runtime:$version"
        }

        object Lifecycle {
            const val version = "2.2.0-alpha05"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Browser {
            const val version = "1.2.0-alpha08"
            const val browser = "androidx.browser:browser:"
        }

        object Test {
            object Runner {
                const val version = "1.2.0"
                const val runnner = "androidx.test:runner:$version"
            }

            object Espresso {
                const val version = "3.2.0"
                const val core = "androidx.test.espresso:espresso-core:$version"
            }
        }
    }

    object Dagger {
        const val versioin = "2.23.2"
        const val dagger = "com.google.dagger:dagger:$versioin"
        const val androidSupport = "com.google.dagger:dagger-android-support:$versioin"
        const val compiler = "com.google.dagger:dagger-compiler:$versioin"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$versioin"
    }

    object Moshi {
        const val version = "1.8.0"
        const val moshi = "com.squareup.moshi:moshi:$version"
        const val adapters = "com.squareup.moshi:moshi-adapters:$version"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val kotlinCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Retrofit {
        const val version = "2.6.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Picasso {
        const val version = "2.71828"
        const val picasso = "com.squareup.picasso:picasso:$version"
    }

    object Spek {
        const val version = "2.0.7"
        const val dslJvm = "org.spekframework.spek2:spek-dsl-jvm:$version"
        const val runnerJUnit5 = "org.spekframework.spek2:spek-runner-junit5:$version"
    }

    object MockK {
        const val version = "1.9.3"
        const val mockk = "io.mockk:mockk:$version"
    }

    object Truth {
        const val version = "1.0"
        const val truth = "com.google.truth:truth:$version"
    }

    object JUnit {
        const val version = "4.12"
        const val junit = "junit:junit:$version"
    }

    object AndroidJUnit5 {
        const val version = "1.5.1.0"
        const val gradlePlugin = "de.mannodermaus.gradle.plugins:android-junit5:$version"
    }

    object Ktlint {
        const val version = "9.2.1"
        const val gradlePlugin = "org.jlleitschuh.gradle:ktlint-gradle:$version"
    }
}
