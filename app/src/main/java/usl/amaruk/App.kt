package usl.amaruk

import android.app.Application
import android.content.Context
import usl.amaruk.prefs.Language
import java.util.*

val language: Language by lazy {
    requireNotNull(App.language)
}

class App : Application() {

    companion object {
        var language: Language? = null
    }

    override fun onCreate() {
        super.onCreate()
        language = Language(applicationContext)
    }
}
