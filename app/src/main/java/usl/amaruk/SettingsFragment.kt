package usl.amaruk

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.Button
import android.widget.SeekBar
import android.widget.Spinner
import androidx.fragment.app.Fragment
import usl.R
import usl.databinding.SettingsFragmentBinding
import usl.amaruk.chooseLang.LanguageItem
import usl.amaruk.chooseLang.SpinAdapter
import usl.amaruk.prefs.SharePrefs
import usl.amaruk.utils.LanguageManager
import usl.databinding.FragmentInfoBinding
import java.util.*

class SettingsFragment : Fragment() {
    private lateinit var sharePrefs: SharePrefs
    private lateinit var binding: SettingsFragmentBinding
    val languageList: ArrayList<LanguageItem> = ArrayList()
    private var currentLang: String = "en"
    lateinit var locale: Locale

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LanguageManager.updateResources(requireContext(), language.getLangCode())
        binding = SettingsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharePrefs = SharePrefs(requireContext())
        (activity as? MainActivity)?.setToolbarTitle(resources.getString(R.string.nav_settings))
        binding.userName.text = sharePrefs.getFullName()
        binding.userEmail.text = sharePrefs.getEmailAddress()
        println("---TIER: ${sharePrefs.getTier()} ---")

/*
        if (sharePrefs.getTier() == "FIARE") {
            binding.userPoems.alpha = 0.5F
            binding.userPoems.isEnabled = false
        } else if (sharePrefs.getTier() =="BASIC") {
            binding.userPoems.alpha = 1F
            binding.userPoems.isEnabled = true
            binding.additionalSettings.visibility = View.GONE
            binding.repeatSongLayout.visibility = View.GONE
            binding.waitText.visibility = View.GONE
            binding.repeatSeekBar.visibility = View.GONE
            sharePrefs.setPoemRepeatStatus(false)
            sharePrefs.setWaitPoemProgress(1)
        } else {
            binding.userPoems.alpha = 1F
            binding.userPoems.isEnabled = true
        }
*/
        val langString: Int = when (language.getLangCode()) {
            "ar" -> R.string.lang_arabic
            "af" -> R.string.lang_afrikaans
            "zh" -> R.string.lang_chinese_mandarin
            "eo" -> R.string.lang_esperanto
            "fr" -> R.string.lang_french
            "de" -> R.string.lang_german
            "hu" -> R.string.lang_hungarian
            "in" -> R.string.lang_indonesian
            "it" -> R.string.lang_italian
            "ja" -> R.string.lang_japanese
            "ko" -> R.string.lang_korean
            "lo" -> R.string.lang_lao
            "mg" -> R.string.lang_malagasy
            "ms" -> R.string.lang_malaysian
            "pt" -> R.string.lang_portugese
            "ru" -> R.string.lang_russian
            "es" -> R.string.lang_spanish
            "sw" -> R.string.lang_swahili
            "th" -> R.string.lang_thai
            "tr" -> R.string.lang_turkish
            "uk" -> R.string.lang_ukrainian
            "ur" -> R.string.lang_urdu
            "vi" -> R.string.lang_vietnamese
            "so" -> R.string.lang_somali
            "bg" -> R.string.lang_bulgarian
            "ro" -> R.string.lang_romanian
            "cs" -> R.string.lang_czech
            "sk" -> R.string.lang_slovak
            "nl" -> R.string.lang_dutch
            "fa" -> R.string.lang_persian
            "sq" -> R.string.lang_albanian
            "el" -> R.string.lang_greek
            "no" -> R.string.lang_norwegian
            "sl" -> R.string.lang_slovenian
            "pl" -> R.string.lang_polish
            "sr" -> R.string.lang_serbian
            "hr" -> R.string.lang_croatian
            "ig" -> R.string.lang_igbo
            "ha" -> R.string.lang_hausa
            "yo" -> R.string.lang_yoruba
            "sv" -> R.string.lang_swedish
            "fi" -> R.string.lang_finnish
            "da" -> R.string.lang_danish
            else -> R.string.lang_english
        }
        val res = resources.getString(R.string.user_interface) + "\n" + resources.getString(langString)
        binding.userInterface.text = res

        val poemInterface: Int = when (language.getPoemsLang()) {
            "hu" -> R.string.lang_hungarian
            else -> R.string.lang_japanese
        }
        val res2 = resources.getString(R.string.setting_poems) + "\n" + resources.getString(poemInterface)
        binding.userPoems.text = res2

        if (sharePrefs.isPoemRepeat()) {
            val repeat =
                resources.getString(R.string.repeat_song) + "\n" + resources.getString(R.string.on)
            binding.repeatSong.text = repeat
            binding.repeatSwitch.isChecked = true
        } else {
            val repeat =
                resources.getString(R.string.repeat_song) + "\n" + resources.getString(R.string.off)
            binding.repeatSong.text = repeat
            binding.repeatSwitch.isChecked = false
        }

        var languageItem: LanguageItem
        binding.waitText.alpha = if (binding.repeatSwitch.isChecked) 1F else 0.5F
        binding.repeatSeekBar.alpha = binding.waitText.alpha
        binding.repeatSeekBar.isEnabled = binding.repeatSwitch.isChecked
        binding.userInterface.setOnClickListener {
            languageList.clear()
            languageItem = LanguageItem(R.drawable.flag_en, resources.getString(R.string.lang_english))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_ja, resources.getString(R.string.lang_japanese))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_hu, resources.getString(R.string.lang_hungarian))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_eo, resources.getString(R.string.lang_esperanto))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_de, resources.getString(R.string.lang_german))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_es, resources.getString(R.string.lang_spanish))
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
            chooseLangDialog()
        }

        binding.userPoems.setOnClickListener {
            languageList.clear()
            languageItem = LanguageItem(R.drawable.flag_ja, resources.getString(R.string.lang_japanese))
            languageList.add(languageItem)
            languageItem = LanguageItem(R.drawable.flag_hu, resources.getString(R.string.lang_hungarian))
            languageList.add(languageItem)
            choosePoemLangDialog()
        }

        binding.repeatSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                sharePrefs.setPoemRepeatStatus(true)
                val repeat =
                    resources.getString(R.string.repeat_song) + "\n" + resources.getString(R.string.on)
                binding.repeatSong.text = repeat
            } else {
                sharePrefs.setPoemRepeatStatus(false)
                val repeat =
                    resources.getString(R.string.repeat_song) + "\n" + resources.getString(R.string.off)
                binding.repeatSong.text = repeat
            }

            binding.waitText.alpha = if (binding.repeatSwitch.isChecked) 1F else 0.5F
            binding.repeatSeekBar.alpha = binding.waitText.alpha
            binding.repeatSeekBar.isEnabled = binding.repeatSwitch.isChecked
        }

        binding.repeatSeekBar.progress = sharePrefs.getWaitPoemProgress()
        binding.waitText.text =
            "${resources.getString(R.string.wait_between_repeats)} (${sharePrefs.getWaitPoemProgress()}s)"

        binding.repeatSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.waitText.text =
                    "${resources.getString(R.string.wait_between_repeats)} (${progress}s)"
                sharePrefs.setWaitPoemProgress(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun chooseLangDialog() {
        val dialog = Dialog(requireContext(), R.style.full_screen_dialog)
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

        val adapter = SpinAdapter(requireContext(), languageList)
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

        spLang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                var userInterface: String
                Log.e("Settings ", "=====> " + languageList[position].name)
                when (position) {
                    1 -> { currentLang = "ja"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_japanese)
                    }
                    2 -> { currentLang = "hu"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_hungarian)
                    }
                    3 -> { currentLang = "eo"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_esperanto)
                    }
                    4 -> { currentLang = "de"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_german)
                    }
                    5 -> { currentLang = "es"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_spanish)
                    }
                    6 -> { currentLang = "ar"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_arabic)
                    }
                    7 -> { currentLang = "af"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_afrikaans)
                    }
                    8 -> { currentLang = "zh"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_chinese_mandarin)
                    }
                    9 -> { currentLang = "fr"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_french)
                    }
                    10 -> { currentLang = "in"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_indonesian)
                    }
                    11 -> { currentLang = "it"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_italian)
                    }
                    12 -> { currentLang = "ko"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_korean)
                    }
                    13 -> { currentLang = "lo"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_lao)
                    }
                    14 -> { currentLang = "mg"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_malagasy)
                    }
                    15 -> { currentLang = "ms"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_malaysian)
                    }
                    16 -> { currentLang = "pt"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_portugese)
                    }
                    17 -> { currentLang = "ru"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_russian)
                    }
                    18 -> { currentLang = "sw"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_swahili)
                    }
                    19 -> { currentLang = "th"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_thai)
                    }
                    20 -> { currentLang = "tr"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_turkish)
                    }
                    21 -> { currentLang = "uk"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_ukrainian)
                    }
                    22 -> { currentLang = "ur"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_urdu)
                    }
                    23 -> { currentLang = "vi"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_vietnamese)
                    }
                    24 -> { currentLang = "so"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_somali)
                    }
                    25 -> { currentLang = "bg"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_bulgarian)
                    }
                    26 -> { currentLang = "ro"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_romanian)
                    }
                    27 -> { currentLang = "cs"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_czech)
                    }
                    28 -> { currentLang = "sk"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_slovak)
                    }
                    29 -> { currentLang = "nl"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_dutch)
                    }
                    30 -> { currentLang = "fa"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_persian)
                    }
                    31 -> { currentLang = "sq"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_albanian)
                    }
                    32 -> { currentLang = "el"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_greek)
                    }
                    33 -> { currentLang = "no"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_norwegian)
                    }
                    34 -> { currentLang = "sl"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_slovenian)
                    }
                    35 -> { currentLang = "pl"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_polish)
                    }
                    36 -> { currentLang = "sr"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_serbian)
                    }
                    37 -> { currentLang = "hr"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_croatian)
                    }
                    38 -> { currentLang = "ig"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_igbo)
                    }
                    39 -> { currentLang = "ha"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_hausa)
                    }
                    40 -> { currentLang = "yo"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_yoruba)
                    }
                    41 -> { currentLang = "sv"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_swedish)
                    }
                    42 -> { currentLang = "fi"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_finnish)
                    }
                    43 -> { currentLang = "da"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_danish)
                    }
                    else -> {
                        currentLang = "en"
                        userInterface = resources.getString(R.string.user_interface) + "\n" + resources.getString(R.string.lang_english)
                    }
                }
                binding.userInterface.text = userInterface
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

    private fun choosePoemLangDialog() {
        val dialog = Dialog(requireContext(), R.style.full_screen_dialog)
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
        val adapter = SpinAdapter(requireContext(), languageList)
        spLang.adapter = adapter
        when {
            language.getPoemsLang() == "ja" -> spLang.setSelection(0)
            language.getPoemsLang() == "hu" -> spLang.setSelection(1)
        }

        spLang.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                Log.e("Settings ", "=====> " + languageList[position].name)
                when (position) {
                    0 -> {
                        currentLang = "ja"
                        val poemInterface =
                            resources.getString(R.string.setting_poems) + "\n" + resources.getString(R.string.lang_japanese)
                        binding.userPoems.text = poemInterface
                    }
                    1 -> {
                        currentLang = "hu"
                        val poemInterface =
                            resources.getString(R.string.setting_poems) + "\n" + resources.getString(R.string.lang_hungarian)
                        binding.userPoems.text = poemInterface
                    }
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        btnSave.setOnClickListener {
            setPoemLang(currentLang)
            dialog.dismiss()
        }
        btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun setAppLocale(localeName: String) {
        language.setLang(localeName)
        val res = resources
        //val dm = res.displayMetrics
        val conf = res.configuration
        var locale = Locale(localeName)
        conf.setLocale(locale)
        //conf.locale = locale
        context?.createConfigurationContext(conf)
        //res.updateConfiguration(conf, dm)
/*
        val baseContextMenu = getActivity()?.getApplicationContext()
        baseContextMenu?.applicationContext?.createConfigurationContext(conf)
        baseContextMenu?.resources?.displayMetrics?.setTo(dm)
*/
        (activity as? MainActivity)?.recreate()
    }

    private fun setPoemLang(localeName: String?) {
        language.setPoemsLang(requireNotNull(localeName))
    }
}
