package usl.amaruk

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build
import androidx.core.content.pm.PackageInfoCompat
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import usl.R
import usl.amaruk.prefs.SharePrefs
import usl.amaruk.utils.*
import usl.amaruk.viewmodel.AuthViewModel
import usl.amaruk.viewmodel.ViewModelFactory
import java.util.*
import android.os.Looper
import android.view.View
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.TextView
import usl.databinding.ActivityMainBinding
import usl.databinding.ActivitySplashBinding

//import kotlinx.android.synthetic.main.activity_splash.*

class SplashScreenActivity : AppCompatActivity(), UIEventManager {
    private lateinit var sharePrefs : SharePrefs
    private lateinit var viewModel: AuthViewModel
    
    companion object {
        const val SPLASH_TIME_OUT: Long = 3000
    }

    private lateinit var bindingActivitySplash: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivitySplash = ActivitySplashBinding.inflate(layoutInflater)
        val viewActivitySplash = bindingActivitySplash.root
        setContentView(viewActivitySplash)
//        setContentView(R.layout.activity_splash)

        var versionName = ""
        try {
            val packageInfo =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(
                        PackageManager.GET_META_DATA.toLong()
                    ))
                } else {
                    @Suppress("DEPRECATION") packageManager.getPackageInfo(packageName, 0)
                }
            //val packageInfo = packageManager.getPackageInfo(packageName, 0)
            //versionName =  packageInfo.versionName+'.'+PackageInfoCompat.getLongVersionCode(packageInfo).toString()
            versionName =  packageInfo.versionName

        } catch (e: NameNotFoundException) {
            e.printStackTrace()
        }

        val pb = findViewById<View>(R.id.progressBar2) as ProgressBar
        val tv = findViewById<View>(R.id.ver_name) as TextView
        tv.text = versionName

        sharePrefs = SharePrefs(this)
        viewModel = ViewModelProvider(this, ViewModelFactory(this)).get(AuthViewModel::class.java)

        if (!language.isLanguageSet()) {

            val deviceLang = Locale.getDefault().language
            if (deviceLang in language.supportedUserInterfaceLanguages) {
                language.setAppLocale(deviceLang)
            }
        }

        LanguageManager.updateResources(this, language.getLangCode())
        val cpyrghtText = resources.getString(R.string.usl_copyright)
        bindingActivitySplash.copyrightText.text = cpyrghtText

        val sharedPref: SharedPreferences = applicationContext
            .getSharedPreferences("poetry", MODE_PRIVATE)
        //val langSaved = sharedPref.getString("locale", "en")
        val lang = language.getPoemsLang()
        val email = sharePrefs.getString(AppConstants.EMAIL_LOGIN)
        val password = sharePrefs.getString(AppConstants.PASSWORD_LOGIN)


        if (sharePrefs.isLogin() && Utils.isOnline(this)) {
            pb.visibility = VISIBLE

            viewModel.userLogin(email?.lowercase(Locale.ROOT)?.md5(), password?.md5(), lang).observe(this, Observer {
                if (it?.access == "granted") {
                    sharePrefs.saveString(AppConstants.DAILY_POEM, it.dailyPoem)
                    sharePrefs.saveString(AppConstants.DAILY_SONG, it.dailySong)
                    sharePrefs.saveInt(AppConstants.DAILY_POEM_NUMBER, it.dailyPoemNumber)
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            })
        }
        else {
            Handler(Looper.getMainLooper()).postDelayed({
                with(sharedPref.edit()) {
                    putString("locale", "ja")
                    commit()
                }
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }, SPLASH_TIME_OUT)
        }
    }

    override fun viewProgressBar() {
    }

    override fun stopProgressBar() {
    }

    override fun viewToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
