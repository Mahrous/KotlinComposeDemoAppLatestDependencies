import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    //new
    alias(libs.plugins.jetbrainsKotlinKsp)
    alias(libs.plugins.hiltPlugin)
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.serialization)

}

android {
    namespace = "com.mahrous.demo_app"

    compileSdk = 37

    defaultConfig {
        applicationId = "com.mahrous.demo_app"
        minSdk = 24
        targetSdk = 36

        versionCode = 6
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)

            freeCompilerArgs.add(
                "-XXLanguage:+PropertyParamAnnotationDefaultTargetMode"
            )
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation (libs.hilt.android)
    implementation (libs.hilt.navigation.compose)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)

    implementation(libs.retrofit)
    implementation(libs.moshi)
    implementation(libs.gson)

    implementation(libs.okhttp3)
    implementation(libs.interceptor)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)


    implementation(libs.coil)
    implementation(libs.navigation)
    implementation(libs.androidx.material3)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.firestore)

    implementation(libs.play.services.auth)
    implementation(libs.play.services.location)
    implementation(libs.play.services.maps)
    implementation(libs.work.runtime.ktx)

    implementation(libs.accompanist.permissions)
    coreLibraryDesugaring(libs.desugar)
    implementation(libs.compose.foundation)
    implementation(libs.places)

    implementation(libs.maps.compose)

    implementation(libs.libphonenumber)
    implementation(libs.maps.utils)
    debugImplementation(libs.compose.ui.test.manifest)
    implementation(libs.country.code.picker)

    implementation(libs.paging.runtime.ktx)
    testImplementation(libs.paging.common.ktx)
    implementation(libs.paging.compose)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.paperdb)


}