package usl.amaruk.apimanager

import androidx.annotation.Keep
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import usl.amaruk.utils.AppConstants
import java.util.concurrent.TimeUnit

val retrofitService by lazy {
    RetrofitClient.create()
}

class RetrofitClient {
    companion object {
        fun create(): RetrofitInterface {

            val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(RetrofitInterface::class.java)
        }
    }


}