package usl.amaruk.repository

import androidx.annotation.Keep
import usl.amaruk.apimanager.RetrofitInterface
import usl.amaruk.apimanager.retrofitService

class ApiRepository {
    var retrofitInterface: RetrofitInterface = retrofitService

    suspend fun userLogin(email: String?, password: String?, poemLang: String?) = retrofitInterface.userLogin(email, password, poemLang)

    suspend fun forgotPassword(email: String, lang: String) = retrofitInterface.forgotPassword(email, lang)
}