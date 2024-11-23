sealed class Build {
    open val isMinifyEnable= false
    open val enableUIntTestCoverage= false
    open val isDebuggable=false
    open val applicationIdSuffix=""
    open val versionNameSuffix=""
    object Debug : Build(){
        override val versionNameSuffix="-DEBUG"
        override val applicationIdSuffix = ".debug"
        override val isMinifyEnable  =false
        override val isDebuggable = true
        override val enableUIntTestCoverage =true
    }
    object ReleaseExternalQA : Build(){
        override val versionNameSuffix="-QA"
        override val applicationIdSuffix = ".releaseExternalQA"
        override val isMinifyEnable  =false
        override val isDebuggable = false
        override val enableUIntTestCoverage =true
    }
    object Release: Build(){
        override val isMinifyEnable  =true
        override val isDebuggable = false
        override val enableUIntTestCoverage =false
    }
}