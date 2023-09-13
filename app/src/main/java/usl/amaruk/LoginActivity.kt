package usl.amaruk

import android.app.Dialog
import android.content.Intent
//import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
//import androidx.annotation.Keep
//import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import usl.R
import usl.databinding.ActivityLoginBinding
import usl.amaruk.base.BaseActivity
import usl.amaruk.chooseLang.LanguageItem
import usl.amaruk.chooseLang.SpinAdapter
import usl.amaruk.prefs.SharePrefs
import usl.amaruk.utils.*
import usl.amaruk.utils.AppConstants.DAILY_POEM
import usl.amaruk.utils.AppConstants.DAILY_POEM_NUMBER
import usl.amaruk.utils.AppConstants.DAILY_SONG
import usl.amaruk.utils.AppConstants.EMAIL_LOGIN
import usl.amaruk.utils.AppConstants.EMAIL_LOGIN_FOR_SESSION
import usl.amaruk.utils.AppConstants.PASSWORD_LOGIN
import usl.amaruk.utils.AppConstants.PASSWORD_LOGIN_FOR_SESSION
import usl.amaruk.viewmodel.AuthViewModel
import usl.amaruk.viewmodel.ViewModelFactory
import java.util.*
import kotlin.collections.ArrayList

class LoginActivity : BaseActivity(), UIEventManager, View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: AuthViewModel
    private lateinit var loader: Loader
    private lateinit var sharePrefs: SharePrefs
    lateinit var locale: Locale
    private var currentLang: String = "en"
    private var checkBoxStatus:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageManager.updateResources(this, language.getLangCode())
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, ViewModelFactory(this))[AuthViewModel::class.java]
        loader = Loader(this)
        sharePrefs = SharePrefs(this)

        binding.loginForgotPasswordTv.setOnClickListener(this)
        binding.loginButton.setOnClickListener(this)
        binding.loginChangeLanguage.setOnClickListener(this)

        val email = sharePrefs.getString(EMAIL_LOGIN)
        val password = sharePrefs.getString(PASSWORD_LOGIN)
        binding.loginRememberMeChkBtn.isChecked = true
        checkBoxStatus = 1

        if(email!!.isNotEmpty())
            binding.loginEmail.setText(email)
        if(password!!.isNotEmpty())
            binding.loginPassword.setText(password)

        binding.loginRememberMeChkBtn.setOnCheckedChangeListener { _, isChecked ->
            checkBoxStatus = if (isChecked) {
                1
            } else {
                0
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_forgot_password_tv -> {
                forgotPassDialog()
            }
            R.id.login_button -> {
                if (Utils.isOnline(this)) {
                    if (validateFields()) {
                        userLogin()
                    }
                }
            }
            R.id.login_change_language -> {
                chooseLangDialog()
            }
        }
    }

    private fun forgotPassDialog() {
        val dialog = Dialog(this, R.style.full_screen_dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_forgot_pass)
        val window: Window? = dialog.window
        val wlp = window?.attributes

        wlp?.gravity = Gravity.CENTER
        window?.attributes = wlp
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val btnSubmit: Button = dialog.findViewById(R.id.btnSubmit)
        val btnCancel: Button = dialog.findViewById(R.id.btnCancel)
        val email: EditText = dialog.findViewById(R.id.Email_for_forgot_password)

        btnSubmit.setOnClickListener {
            if (Utils.isOnline(this)) {
                if (email.text.toString().isEmpty()) {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.valid_email),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val lang = language.getLangCode()
                    forgotPassword(email.text.toString().md5(), lang)
                    dialog.dismiss()
                }
            }
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun forgotPassword(email: String, lang: String) {
        viewModel.forgotPassword(email, lang).observe(this) {
            if (it?.access == "CallingNewPasswOK") {
                viewToast(resources.getString(R.string.dialog_password_sent_message))
            } else {
                viewToast(requireNotNull(it?.access))
            }
        }
    }

    private fun chooseLangDialog() {
        val dialog = Dialog(this, R.style.full_screen_dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_change_language)
        val window: Window? = dialog.window
        val wlp = window?.attributes

        wlp?.gravity = Gravity.CENTER
        window?.attributes = wlp
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val btnSave: Button = dialog.findViewById(R.id.btnSave)
        val btnCancel: Button = dialog.findViewById(R.id.btnChangeLangCancel)
        val spLang: Spinner = dialog.findViewById(R.id.spLang)

        val languageList: ArrayList<LanguageItem> = ArrayList()
        var languageItem = LanguageItem(R.drawable.flag_en, resources.getString(R.string.lang_english))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ja,resources.getString(R.string.lang_japanese))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_hu,resources.getString(R.string.lang_hungarian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_eo,resources.getString(R.string.lang_esperanto))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_de,resources.getString(R.string.lang_german))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_es,resources.getString(R.string.lang_spanish))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ar, resources.getString(R.string.lang_arabic))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_af, resources.getString(R.string.lang_afrikaans))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_zh, resources.getString(R.string.lang_chinese_mandarin))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_fr, resources.getString(R.string.lang_french))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_in, resources.getString(R.string.lang_indonesian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_it, resources.getString(R.string.lang_italian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ko, resources.getString(R.string.lang_korean))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_lo, resources.getString(R.string.lang_lao))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_mg, resources.getString(R.string.lang_malagasy))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ms, resources.getString(R.string.lang_malaysian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_pt, resources.getString(R.string.lang_portugese))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ru, resources.getString(R.string.lang_russian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sw, resources.getString(R.string.lang_swahili))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_th, resources.getString(R.string.lang_thai))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_tr, resources.getString(R.string.lang_turkish))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_uk, resources.getString(R.string.lang_ukrainian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ur, resources.getString(R.string.lang_urdu))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_vi, resources.getString(R.string.lang_vietnamese))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_so, resources.getString(R.string.lang_somali))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_bg, resources.getString(R.string.lang_bulgarian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ro, resources.getString(R.string.lang_romanian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_cs, resources.getString(R.string.lang_czech))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sk, resources.getString(R.string.lang_slovak))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_nl, resources.getString(R.string.lang_dutch))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_fa, resources.getString(R.string.lang_persian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sq, resources.getString(R.string.lang_albanian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_el, resources.getString(R.string.lang_greek))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_no, resources.getString(R.string.lang_norwegian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sl, resources.getString(R.string.lang_slovenian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_pl, resources.getString(R.string.lang_polish))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sr, resources.getString(R.string.lang_serbian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_hr, resources.getString(R.string.lang_croatian))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ig, resources.getString(R.string.lang_igbo))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_ha, resources.getString(R.string.lang_hausa))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_yo, resources.getString(R.string.lang_yoruba))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_sv, resources.getString(R.string.lang_swedish))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_fi, resources.getString(R.string.lang_finnish))
        languageList.add(languageItem)
        languageItem = LanguageItem(R.drawable.flag_da, resources.getString(R.string.lang_danish))
        languageList.add(languageItem)
        val adapter = SpinAdapter(this, languageList)
        spLang.adapter = adapter

        when (language.getLangCode()) {
            "ja" -> spLang.setSelection(1)
            "hu" -> spLang.setSelection(2)
            "eo" -> spLang.setSelection(3)
            "de" -> spLang.setSelection(4)
            "es" -> spLang.setSelection(5)
            "ar" -> spLang.setSelection(6)
            "af" -> spLang.setSelection(7)
            "zh" -> spLang.setSelection(8)
            "fr" -> spLang.setSelection(9)
            "in" -> spLang.setSelection(10)
            "it" -> spLang.setSelection(11)
            "ko" -> spLang.setSelection(12)
            "lo" -> spLang.setSelection(13)
            "mg" -> spLang.setSelection(14)
            "ms" -> spLang.setSelection(15)
            "pt" -> spLang.setSelection(16)
            "ru" -> spLang.setSelection(17)
            "sw" -> spLang.setSelection(18)
            "th" -> spLang.setSelection(19)
            "tr" -> spLang.setSelection(20)
            "uk" -> spLang.setSelection(21)
            "ur" -> spLang.setSelection(22)
            "vi" -> spLang.setSelection(23)
            "so" -> spLang.setSelection(24)
            "bg" -> spLang.setSelection(25)
            "ro" -> spLang.setSelection(26)
            "cs" -> spLang.setSelection(27)
            "sk" -> spLang.setSelection(28)
            "nl" -> spLang.setSelection(29)
            "fa" -> spLang.setSelection(30)
            "sq" -> spLang.setSelection(31)
            "el" -> spLang.setSelection(32)
            "no" -> spLang.setSelection(33)
            "sl" -> spLang.setSelection(34)
            "pl" -> spLang.setSelection(35)
            "sr" -> spLang.setSelection(36)
            "hr" -> spLang.setSelection(37)
            "ig" -> spLang.setSelection(38)
            "ha" -> spLang.setSelection(39)
            "yo" -> spLang.setSelection(40)
            "sv" -> spLang.setSelection(41)
            "fi" -> spLang.setSelection(42)
            "da" -> spLang.setSelection(43)
            else -> spLang.setSelection(0)
        }

        spLang.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                Log.e("You select ", "=====> " + languageList[position].name)

                currentLang = when (position) {
                    1 -> "ja"
                    2 -> "hu"
                    3 -> "eo"
                    4 -> "de"
                    5 -> "es"
                    6 -> "ar"
                    7 -> "af"
                    8 -> "zh"
                    9 -> "fr"
                    10 -> "in"
                    11 -> "it"
                    12 -> "ko"
                    13 -> "lo"
                    14 -> "mg"
                    15 -> "ms"
                    16 -> "pt"
                    17 -> "ru"
                    18 -> "sw"
                    19 -> "th"
                    20 -> "tr"
                    21 -> "uk"
                    22 -> "ur"
                    23 -> "vi"
                    24 -> "so"
                    25 -> "bg"
                    26 -> "ro"
                    27 -> "cs"
                    28 -> "sk"
                    29 -> "nl"
                    30 -> "fa"
                    31 -> "sq"
                    32 -> "el"
                    33 -> "no"
                    34 -> "sl"
                    35 -> "pl"
                    36 -> "sr"
                    37 -> "hr"
                    38 -> "ig"
                    39 -> "ha"
                    40 -> "yo"
                    41 -> "sv"
                    42 -> "fi"
                    43 -> "da"
                    else -> "en"
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        btnSave.setOnClickListener {
            setAppLocale(currentLang)
            dialog.dismiss()
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun userLogin() {
        val email = binding.loginEmail.text.toString().lowercase().md5()
        val password = binding.loginPassword.text.toString().md5()
        val lang = language.getPoemsLang()
        viewModel.userLogin(email, password, lang).observe(this) {
            if (it?.access == "granted") {
                if (checkBoxStatus == 1) {
                    sharePrefs.saveString(EMAIL_LOGIN, binding.loginEmail.text.toString())
                    sharePrefs.saveString(PASSWORD_LOGIN, binding.loginPassword.text.toString())

                } else {
                    sharePrefs.saveString(EMAIL_LOGIN, "")
                    sharePrefs.saveString(PASSWORD_LOGIN, "")
                }
                sharePrefs.saveString(EMAIL_LOGIN_FOR_SESSION, binding.loginEmail.text.toString())
                sharePrefs.saveString(
                    PASSWORD_LOGIN_FOR_SESSION,
                    binding.loginPassword.text.toString()
                )
                sharePrefs.rememberMe(true)
                sharePrefs.login(it)
                sharePrefs.saveString(DAILY_POEM, it.dailyPoem)
                sharePrefs.saveString(DAILY_SONG, it.dailySong)
                sharePrefs.saveInt(DAILY_POEM_NUMBER, it.dailyPoemNumber)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                viewToast(resources.getString(R.string.wrong_credentials))
            }
            //println("----loginResponse---${it.toString()}")
        }
    }

    // function to validate fields
    private fun validateFields(): Boolean {
        if (binding.loginEmail.text.toString().isEmpty()) {
            Toast.makeText(this, resources.getString(R.string.valid_email), Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (binding.loginPassword.text.toString().isEmpty()) {
            Toast.makeText(this, resources.getString(R.string.valid_password), Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }

    override fun viewProgressBar() {
        loader.alertShow()
    }

    override fun stopProgressBar() {
        loader.alertHide()
    }

    override fun viewToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        loader.alertHide()
    }
    private fun setAppLocale(localeName: String) {
        println("--langName---$localeName")
            language.setLang(localeName)
            val res = resources
            //val dm = res.displayMetrics
            val conf = res.configuration
            val locale = Locale(localeName)
            conf.setLocale(locale)
            //conf.locale = locale
            createConfigurationContext(conf)
            //res.updateConfiguration(conf, dm)
/*
            val baseContextMenu = getApplicationContext()
            baseContextMenu?.applicationContext?.createConfigurationContext(conf)
            baseContextMenu?.resources?.displayMetrics?.setTo(dm)
*/
            val refresh = Intent(
                this,
                LoginActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            this.overridePendingTransition(0, 0)
            this.startActivity(intent)
            this.finish()
            this.overridePendingTransition(0, 0)
    }
}