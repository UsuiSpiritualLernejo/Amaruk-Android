package usl.amaruk.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
//import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.json.JSONObject
import usl.R
import usl.amaruk.HomeFragment
import usl.amaruk.language
import usl.amaruk.prefs.SharePrefs
import usl.databinding.FragmentHomeBinding
import usl.databinding.FragmentInfoBinding
import java.io.IOException
import java.util.*

object Utils: Fragment() {

    private val mHandler: Handler = Handler(Looper.getMainLooper())
    private var mUiThread: Thread? = null
//    private lateinit var sharePrefs: SharePrefs
//    private lateinit var bindingFragmentHome: FragmentHomeBinding

    fun isOnline(context: Context?): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
        }
        /*
        else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
         */
        return false
    }
/*
    fun GetDailyPoem(objPoem: TextView) {
        sharePrefs = SharePrefs(requireContext())

        this@Utils.runOnUiThread(java.lang.Runnable {
            objPoem.text = resources.getString(R.string.refresh_poem)
            setPlayVisible(false)
        })

        var poem = ""
        var poemNum = -1
        val email = sharePrefs.getString(AppConstants.EMAIL_LOGIN_FOR_SESSION)?.toLowerCase(Locale.ROOT)?.md5()
        val password =  sharePrefs.getString(AppConstants.PASSWORD_LOGIN_FOR_SESSION)?.md5()
        val lang = language.getPoemsLang()
        val masterURL = AppConstants.BASE_URL+"exec?userid=$email&passwd=$password&poemLang=$lang&secret=USL-WakaPoems"
        val request = Request.Builder().url(masterURL).build()
        val client = OkHttpClient()
        var httpResponse: JSONObject

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {}

            override fun onResponse(call: Call, response: Response) {
                httpResponse = JSONObject(response.body()?.string()!!)

                if (httpResponse.has("access") && httpResponse.getString("access") == "granted") {
                    poem = httpResponse.getString("dailyPoem")
                    poemNum = httpResponse.getInt("dailyPoemNumber")
                }

                sharePrefs.saveString(AppConstants.DAILY_POEM, poem)
                sharePrefs.saveInt(AppConstants.DAILY_POEM_NUMBER, poemNum)

                this@Utils.runOnUiThread(java.lang.Runnable {
                    objPoem.text = HtmlCompat.fromHtml(poem, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    //setPlayVisible(true)
                })
            }
        })
    }

    fun GetDailySong() {
        sharePrefs = SharePrefs(requireContext())

        var song: String
        val email = sharePrefs.getString(AppConstants.EMAIL_LOGIN_FOR_SESSION)?.toLowerCase(Locale.ROOT)?.md5()
        val password =  sharePrefs.getString(AppConstants.PASSWORD_LOGIN_FOR_SESSION)?.md5()
        val masterURL = AppConstants.BASE_URL+"exec?userid=$email&passwd=$password&secret=USL-WakaSong"
        val request = Request.Builder().url(masterURL).build()
        val client = OkHttpClient()
        var httpResponse: JSONObject

        client.newCall(request).enqueue(object : Callback {

            override fun onFailure(call: Call, e: IOException) {}

            override fun onResponse(call: Call, response: Response) {
                httpResponse = JSONObject(response.body()?.string()!!)

                if (httpResponse.has("access") && httpResponse.getString("access") == "granted") {
                    song = httpResponse.getString("song")
                    sharePrefs.saveSong(song)
                }

                this@Utils.runOnUiThread(java.lang.Runnable {
                    setPlayVisible(true)
                })
            }
        })
    }

    private fun runOnUiThread(runnable: Runnable) {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }

    private fun setPlayVisible(visible: Boolean) {
        if (sharePrefs.getTier() != "BASIC") {
            if (visible) {
                HomeFragment().play.visibility = View.VISIBLE
            }
            else {
                HomeFragment().play.visibility = View.GONE
            }
        }
    }
*/
}


