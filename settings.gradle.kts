pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeIntro2"
include(":app")
include(":app:sayfalararasigecis")
include(":app:sayfalararasi_veritransferi")
include(":app:sayfalararasi_veritransferi_nesnetabanli")
include(":app:button_text_textfield_kullanimi")
include(":app:dropdown_menu_kullanimi")
include(":app:dinamik_dropdown_menu_kullanimi")
include(":app:topappbar")
include(":app:lazycolumn_dinamiklisteleme")
include(":app:navigationbar_kullanimi")
include(":app:mvvm_kullanimi")
include(":app:room_db")
