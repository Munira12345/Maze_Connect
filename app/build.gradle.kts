plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
   // id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.mazeconnect"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mazeconnect"
        minSdk = 24
        targetSdk = 34
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
    implementation(project(":feature:homescreen"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")
    implementation ("io.insert-koin:koin-android:3.4.0")
    implementation ("io.insert-koin:koin-androidx-compose:3.4.0")

    implementation("androidx.navigation:navigation-compose:2.4.0-alpha10")
    implementation("com.google.firebase:firebase-auth-ktx:21.0.1")
        implementation(platform("com.google.firebase:firebase-bom:29.0.3"))



    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


        implementation("androidx.compose.ui:ui:1.5.0")
        implementation("androidx.compose.material:material:1.5.0")
        implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
        debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
        implementation("androidx.activity:activity-compose:1.8.0")

        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")


        implementation("androidx.navigation:navigation-compose:2.7.1")

        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")


        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

        implementation("com.google.dagger:hilt-android:2.47")

        implementation("androidx.hilt:hilt-navigation-compose:1.1.0-alpha01")


            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        implementation("androidx.room:room-runtime:2.5.2")
    
        implementation("androidx.room:room-ktx:2.5.2")








    }