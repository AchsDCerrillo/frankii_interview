plugins {
    id("kotlin-kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id(libs.plugins.di.hilt.get().pluginId)
}

android {
    namespace = Module.Core.Network.namespace
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"${BuildType.Debug.serverUrl}\"")
            buildConfigField("String", "API_KEY", "\"${BuildType.Debug.apiKey}\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"${BuildType.Debug.serverUrl}\"")
            buildConfigField("String", "API_KEY", "\"${BuildType.Release.apiKey}\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.bundles.network.bundle)
    implementation(libs.bundles.coroutines.bundle)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    useModules(
        coreDiModule
    )
}

kapt {
    correctErrorTypes = true
}