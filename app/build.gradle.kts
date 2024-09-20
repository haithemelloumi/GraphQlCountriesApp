plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    //alias(libs.plugins.apollographql.apollo3)
    alias(libs.plugins.apollo)
    // dagger hilt
    alias(libs.plugins.dagger.hilt.android)
    // ksp
    alias(libs.plugins.devtools.ksp)
}

// Apollo needs a `.graphqls` or a `.json` schema
apollo {
    service("service") {
        packageName.set("com.helloumi")
    }
}

android {
    namespace = "com.helloumi.graphqlcountriesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.helloumi.graphqlcountriesapp"
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
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }
    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //------------------------------------- Jetpack Compose -------------------------------------//
    ///////////////////////////////////////////// BOM /////////////////////////////////////////////
    val composeBom = platform(libs.compose.bom)

    implementation(platform(composeBom))
    androidTestImplementation(platform(composeBom))

    // Ui
    implementation(libs.compose.ui)
    implementation(libs.activity.compose)

    // Navigation
    implementation(libs.navigation.compose)

    // ViewModel
    implementation(libs.lifecycle.viewmodel.compose)

    // Material Design 3
    implementation(libs.material3)

    // Compose ViewBinding
    implementation(libs.ui.viewbinding)

    // Tooling
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)

    // UI Tests
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)

    ///////////////////////////////////////////// BOM /////////////////////////////////////////////

    // Hilt compose
    implementation(libs.hilt.navigation.compose)

    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Apollo
    implementation(libs.apollo.runtime)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.test.manifest)
}
