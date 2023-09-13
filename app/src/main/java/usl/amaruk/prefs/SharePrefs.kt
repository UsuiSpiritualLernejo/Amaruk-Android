package usl.amaruk.prefs

import android.content.Context
import android.content.SharedPreferences
import usl.amaruk.model.UserLoginModel

class SharePrefs(private val context: Context) {

    private val sharePrefName = "user info"
    private val prefs: SharedPreferences =
        context.getSharedPreferences(sharePrefName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = prefs.edit();
    private val userLogin = "login"
    private val firstName = "first_name"
    private val lastName = "last_name"
    private val email = "email_address"
    private val tier = "tier"
    private val poemRepeatStatus = "poem_repeat"
    private val waitPoemProgress = "poem_wait_progress"

    /*--function to clear preferences--*/
    fun clearSharedPreference() {
        editor.clear().apply()
    }

    fun login(userLoginModel: UserLoginModel) {
        editor.putString(firstName, userLoginModel.firstName)
        editor.putString(lastName, userLoginModel.lastName)
        editor.putString(email, userLoginModel.emailAddress)
        editor.putString(tier,userLoginModel.tier)
        editor.apply()
    }

    fun rememberMe(rememberMe: Boolean) {
        editor.putBoolean(userLogin, rememberMe).apply()
    }

    fun isLogin(): Boolean {
        return prefs.getBoolean(userLogin, false)
    }

    fun getFirstName(): String? {
        return prefs.getString(firstName, "")
    }

    fun getLastName(): String? {
        return prefs.getString(lastName, "")
    }

    fun getFullName(): String? {
        return prefs.getString(firstName, "") + " " + prefs.getString(lastName, "")
    }

    fun getEmailAddress(): String? {
        return prefs.getString(email, "")
    }

    fun getTier(): String? {
        return prefs.getString(tier, "")
    }

    fun saveString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.apply()
    }

    fun saveInt(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String?): Int? {
        return prefs.getInt(key, 0)
    }

    fun getString(key: String?): String? {
        return prefs.getString(key, "")
    }

    fun setPoemRepeatStatus(status : Boolean)  {
        editor.putBoolean(poemRepeatStatus, status).apply()
    }

    fun isPoemRepeat() : Boolean {
        return prefs.getBoolean(poemRepeatStatus, false)
    }

    fun setWaitPoemProgress(progress : Int)  {
        editor.putInt(waitPoemProgress, progress).apply()
    }

    fun getWaitPoemProgress() : Int {
        return prefs.getInt(waitPoemProgress, 1)
    }
}