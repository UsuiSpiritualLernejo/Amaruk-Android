package usl.amaruk.utils

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import androidx.fragment.app.Fragment
import java.util.*

object LanguageManager : Fragment() {

    fun updateResources(context: Context, language: String) {

        val resources = context.resources
        val configuration = Configuration()
        val locale = Locale(language)
        Locale.setDefault(locale)

        //configuration.locale = locale
        //resources.updateConfiguration(configuration, resources.displayMetrics)

        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)

        // Create a new context with the updated configuration
        //val newContext = context.createConfigurationContext(configuration)

        // Use the new context for further operations
        // For example, you can assign it to your existing context variable
        //context = newContext


/*
        val resources = context.resources
        val configuration = Configuration()

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            val locale = configuration.locales.get(0)
            //Locale.setDefault(locale)
            configuration.setLocale(locale)
            context.createConfigurationContext(configuration)
            resources.updateConfiguration(configuration, resources.displayMetrics)
            //resources.configuration.setTo(configuration)

        } else {

            val locale = Locale(language)
            Locale.setDefault(locale)
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }
*/
/*
        val baseContextMenu = getActivity()?.getApplicationContext()
        baseContextMenu?.applicationContext?.createConfigurationContext(configuration)
        baseContextMenu?.resources?.displayMetrics?.setTo(resources.displayMetrics)
 */
    }
}