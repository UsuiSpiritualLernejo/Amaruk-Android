package usl.amaruk.apimanager

import androidx.annotation.Keep
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import usl.amaruk.model.ForgetPasswordModel
import usl.amaruk.model.SongModel
import usl.amaruk.model.UserLoginModel

interface RetrofitInterface {

    @GET("exec")
    suspend fun userLogin(@Query("userid") email: String?, @Query("passwd") password: String?, @Query("poemLang") poemLang: String?,
                          @Query("secret") secret : String = "USL-WakaPoems"): UserLoginModel

    @GET("exec")
    suspend fun forgotPassword(@Query("userid") email: String?, @Query("lang") lang: String?,
                               @Query("secret") secret : String = "USL-WakaPoems-PasswForget"): ForgetPasswordModel
}