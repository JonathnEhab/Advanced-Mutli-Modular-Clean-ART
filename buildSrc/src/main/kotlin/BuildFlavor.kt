import com.android.build.api.dsl.ApplicationBaseFlavor
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

sealed class BuildFlavor (val name:String) {
    //use for APP
     abstract fun create(namedDomainObjectContainer :NamedDomainObjectContainer<ApplicationProductFlavor>)
     :ApplicationBaseFlavor
     //use for modules
    abstract fun createLibrary(namedDomainObjectContainer :NamedDomainObjectContainer<LibraryProductFlavor>)
    :LibraryProductFlavor

    //GOOGLE
    object Google : BuildFlavor(FlavorTypes.GOOGLE){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationBaseFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDonations.STORE
                applicationIdSuffix= ".$name"
                versionNameSuffix="-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
                return namedDomainObjectContainer.create(name){
                    dimension=BuildDonations.STORE
                }
        }

    }

    //HUAWEI
    object Huawei : BuildFlavor(FlavorTypes.HUAWEI){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationBaseFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDonations.STORE
                applicationIdSuffix= ".$name"
                versionNameSuffix="-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension=BuildDonations.STORE
            }
        }

    }

    //DRIVER
    object Driver : BuildFlavor(FlavorTypes.DRIVER){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationBaseFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDonations.APP
                applicationIdSuffix= ".$name"
                versionNameSuffix="-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension=BuildDonations.APP
            }
        }

    }

    //CLIENT
    object Client : BuildFlavor(FlavorTypes.CLIENT){
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationBaseFlavor {
            return namedDomainObjectContainer.create(name){
                dimension = BuildDonations.APP
                applicationIdSuffix= ".$name"
                versionNameSuffix="-$name"
            }
        }

        override fun createLibrary(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name){
                dimension=BuildDonations.APP
            }
        }

    }
}