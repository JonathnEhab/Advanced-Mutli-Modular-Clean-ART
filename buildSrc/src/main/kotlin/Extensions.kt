
import com.android.build.api.dsl.ApplicationBuildType
import org.gradle.api.Project
import java.util.Properties
private const val LOCAL_PROPERTIES_FILE_NAME="dev_credentials.properties"
fun Project.getLocalProperty( propertyName :String):String{
    val localProperties= Properties().apply {
        val localPropertyFile=project.rootProject.file(LOCAL_PROPERTIES_FILE_NAME)
        if (localPropertyFile.exists()){
            load(localPropertyFile.inputStream())
        }
    }
       return localProperties.getProperty(propertyName)?:throw
               NoSuchElementException("Property Not Found : $propertyName")
           }
fun ApplicationBuildType.buildConfigStringField( name :String , value: String){
    this.buildConfigField("String",name,value)
}
fun ApplicationBuildType.buildConfigIntField( name :String , value: String){
    this.buildConfigField("int",name,value)
}
fun ApplicationBuildType.buildConfigBooleanField( name :String , value: String){
    this.buildConfigField("boolean",name,value)
}