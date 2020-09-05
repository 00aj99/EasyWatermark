import ProductFlavors.coolApk
import ProductFlavors.github
import ProductFlavors.googlePlay
import ProductFlavors.others
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion(Apps.buildTools)

    defaultConfig {
        applicationId = "me.rosuh.easywatermark"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        getByName(BuildTypes.Debug) {
            isMinifyEnabled = false
            applicationIdSuffix = ".${BuildTypes.Debug}"
            versionNameSuffix = ".${BuildTypes.Debug}"
            isDebuggable = true
        }

        getByName(BuildTypes.Release) {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions("version")

    productFlavors {
        create(googlePlay) {
            versionNameSuffix = "-${googlePlay}"
        }
        create(github) {
            versionNameSuffix = "-${github}"
        }
        create(coolApk) {
            versionNameSuffix = "-${coolApk}"
        }
        create(others) {
            isDefault = true
            versionNameSuffix = "-${others}"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.appcompat)
    implementation(Libs.compressor)
    implementation(Libs.materialAboutLibrary)
    implementation(Libs.material)
    implementation(Libs.fragmentKtx)
    implementation(Libs.lifecycleLiveData)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.colorPickerView)
    implementation(Libs.viewpager2)
    implementation(Libs.recycleView)
    implementation(Libs.constraintLayout)
    implementation(Libs.coreKtx)
    implementation(Libs.gifDrawable)
    testImplementation(TestLibs.junit)
}