plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.amin.rides"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.amin.rides"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            buildConfigField("String","Base_URL","\"https://random-data-api.com/api/\"")
        }
        release {
            buildConfigField("String","Base_URL","\"https://random-data-api.com/api/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {

    //region androidx
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.legacy.support.v4)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation (libs.androidx.swiperefreshlayout)
    //endregion

    //region material design
    implementation(libs.material)

    //endregion

    //region test
    testImplementation(libs.junit)
    testImplementation(libs.junit.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //endregion

    //region networking(retrofit)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //endregion


    //region db(room)
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    kapt (libs.androidx.room.compiler)
    //endregion

    //region di(dagger)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    //endregion

    //region async
    implementation(libs.kotlinx.coroutines.android)
    //endregion
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}