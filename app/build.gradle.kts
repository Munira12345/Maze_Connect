plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
   // id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.mazeconnect"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mazeconnect"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.firebase.bom)
    implementation(libs.firebase.analytics)
    implementation (libs.firebase.analytics.ktx)
    implementation (libs.firebase.auth.ktx)

    implementation (libs.koin.android)
    implementation (libs.koin.androidx.compose)

    implementation(libs.androidx.navigation.compose.v240alpha10)
    implementation(libs.google.firebase.auth.ktx)


    implementation(libs.androidx.core.ktx.v1150)
    implementation(libs.androidx.appcompat.v161)
    implementation(libs.material.v190)
    implementation(libs.androidx.constraintlayout)


        implementation(libs.ui)
        implementation(libs.androidx.material)
        implementation(libs.ui.tooling.preview)
        debugImplementation(libs.ui.tooling)
        implementation(libs.androidx.activity.compose.v193)

        implementation(libs.androidx.lifecycle.runtime.ktx.v287)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)


        implementation(libs.navigation.compose)

        implementation(libs.androidx.lifecycle.livedata.ktx)


        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)

        implementation(libs.hilt.android)

        implementation(libs.androidx.hilt.navigation.compose)


            implementation(libs.retrofit)
            implementation(libs.converter.gson)

        implementation(libs.androidx.room.runtime)
    
        implementation(libs.androidx.room.ktx)








    }