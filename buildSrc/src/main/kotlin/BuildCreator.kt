import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationBuildType
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.utils.`is`

sealed class BuildCreator(val name:String) {

    abstract fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>) : ApplicationBuildType


    class Debug(private val project: Project): BuildCreator(BuildTypes.DEBUG){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.getByName(name){
                isMinifyEnabled = Build.Debug.isMinifyEnable
                isDebuggable = Build.Debug.isDebuggable
                versionNameSuffix = Build.Debug.versionNameSuffix
                applicationIdSuffix = Build.Debug.applicationIdSuffix
                enableUnitTestCoverage = Build.Debug.enableUIntTestCoverage
            }
        }
    }

    class Release(private val project: Project): BuildCreator(BuildTypes.RELEASE){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.getByName(name){
                isMinifyEnabled = Build.Release.isMinifyEnable
                enableUnitTestCoverage = Build.Release.enableUIntTestCoverage
                isDebuggable = Build.Release.isDebuggable
            }
        }
    }

    class ReleaseExternalQa(private val project: Project): BuildCreator(BuildTypes.RELEASE_EXTERNAL_QA){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationBuildType>): ApplicationBuildType {
            return namedDomainObjectContainer.create(name){
                isMinifyEnabled = Build.ReleaseExternalQA.isMinifyEnable
                enableUnitTestCoverage = Build.ReleaseExternalQA.enableUIntTestCoverage
                isDebuggable = Build.ReleaseExternalQA.isDebuggable
                versionNameSuffix = Build.ReleaseExternalQA.versionNameSuffix
                applicationIdSuffix = Build.ReleaseExternalQA.applicationIdSuffix
            }
        }
    }
}