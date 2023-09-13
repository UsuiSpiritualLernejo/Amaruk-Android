package usl.amaruk.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.ContentProviderCompat.requireContext
import usl.amaruk.MainActivity
import usl.amaruk.language
import java.util.*

class Language(context: Context) {

    private val sharePrefName="pref_lang"
    private val type=""
    private var context = context
    private val prefs: SharedPreferences = context.getSharedPreferences(sharePrefName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor=prefs.edit()
    private val poemsLang="poems_lang"
    val supportedUserInterfaceLanguages = arrayOf("en", "hu", "ja", "eo")

    fun setLang(language:String){
        editor.putString(type,language)
        editor.apply()
        editor.commit()
    }

    fun isLanguageSet():Boolean{
        val res = prefs.getString(type, "")
        return  res != ""
    }

    fun getLangCode():String{
        return requireNotNull(prefs.getString(type,"en"))
    }

    fun setPoemsLang(language:String){
        editor.putString(poemsLang,language)
        editor.apply()
        editor.commit()
    }

    fun getPoemsLang():String{
        return requireNotNull(prefs.getString(poemsLang,"ja"))
    }

    fun clearPoemLang(){
        editor.putString(poemsLang,"ja")
        editor.apply()
        editor.commit()
    }

    fun setAppLocale(localeName: String) {
        language.setLang(localeName)
        val res = this.context.resources
        //val dm = res.displayMetrics
        val conf = res.configuration

        var locale = Locale(localeName)
        conf.setLocale(locale)
        //conf.locale = locale
        context.createConfigurationContext(conf)
        //res.updateConfiguration(conf, dm)
/*
        val baseContextMenu = getActivity()?.getApplicationContext()
        baseContextMenu?.applicationContext?.createConfigurationContext(conf)
        baseContextMenu?.resources?.displayMetrics?.setTo(dm)
*/
        //(activity as? MainActivity)?.recreate()
    }

}