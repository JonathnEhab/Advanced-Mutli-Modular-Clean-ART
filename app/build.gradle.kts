plugins {
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.ANDROID_APP)
}

android {
    namespace = BuildConfig.APP_ID
    compileSdk = BuildConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = BuildPlugins.ANDROID_APP
        minSdk = BuildConfig.MIM_SDK_VERSION
        targetSdk = BuildConfig.Target_SDK_VERSION
        versionCode = ReleaseConfig.VERSION_CODE
        versionName = ReleaseConfig.VERSION_NAME
        testInstrumentationRunner = TestBuildConfig.TEATS_INSTRUMENTATION_RUNNER
    }

    buildTypes {
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
}

dependencies {

}