import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationBuildType
import com.android.build.api.variant.BuildConfigField
import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

sealed class BuildCreator(val name:String) {
    abstract fun create(namedDomainObjectContainer : NamedDomainObjectContainer<ApplicationBuildType>) :ApplicationBuildType
    class Debug(private val project: Project):BuildCreator(BuildTypes.DEBUG){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.getByName(name){
                isMinifyEnabled= Build.Debug.isMinifyEnable
                enableUnitTestCoverage=Build.Debug.enableUIntTestCoverage
                isDebuggable=Build.Debug.isDebuggable
                versionNameSuffix=Build.Debug.versionNameSuffix
                applicationIdSuffix=Build.Debug.applicationIdSuffix
                buildConfigStringField(BuildVariables.BASE_URL,project.getLocalProperty("dev.pro_endpoint"))
                buildConfigIntField(BuildVariables.DB_VERSION,project.getLocalProperty("dev.clear_cache"))
                buildConfigBooleanField(BuildVariables.DB_VERSION,project.getLocalProperty("dev.clear_cache"))
                buildConfigStringField(BuildVariables.MAP_KEY,project.getLocalProperty("release.map_key"))
            }

        }

    }
    class ReleaseExternalQA(private val project: Project):BuildCreator(BuildTypes.RELEASE_EXTERNAL_QA){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.create(name){
                isMinifyEnabled= Build.ReleaseExternalQA.isMinifyEnable
                enableUnitTestCoverage=Build.ReleaseExternalQA.enableUIntTestCoverage
                isDebuggable=Build.ReleaseExternalQA.isDebuggable
                versionNameSuffix=Build.ReleaseExternalQA.versionNameSuffix
                applicationIdSuffix=Build.ReleaseExternalQA.applicationIdSuffix

                buildConfigStringField(BuildVariables.BASE_URL,project.getLocalProperty("dev.qa_endpoint"))
                buildConfigIntField(BuildVariables.DB_VERSION,project.getLocalProperty("dev.db.version"))
                buildConfigBooleanField(BuildVariables.DB_VERSION,project.getLocalProperty("dev.clear_cache"))
                buildConfigStringField(BuildVariables.MAP_KEY,project.getLocalProperty("dev.map_key"))
            }

        }

    }
    class Release(private val project: Project):BuildCreator(BuildTypes.RELEASE){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.getByName(name){
                isMinifyEnabled= Build.Release.isMinifyEnable
                enableUnitTestCoverage=Build.Release.enableUIntTestCoverage
                isDebuggable=Build.Release.isDebuggable
            }

        }

    }

}