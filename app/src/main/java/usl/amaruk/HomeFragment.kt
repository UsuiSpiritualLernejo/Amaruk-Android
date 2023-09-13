package usl.amaruk

//import usl.amaruk.repository.ApiRepository
//import usl.amaruk.presenter.Hungarian
//import usl.amaruk.presenter.Japanese
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
//import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.json.JSONObject
import usl.R
import usl.amaruk.prefs.SharePrefs
import usl.amaruk.utils.*
import usl.amaruk.utils.AppConstants.DAILY_POEM
import usl.amaruk.utils.AppConstants.DAILY_POEM_NUMBER
import usl.amaruk.utils.AppConstants.DAILY_SONG
import usl.databinding.FragmentHomeBinding
import java.io.IOException
import java.util.*

class HomeFragment: Fragment() {

    val mHandler: Handler = Handler(Looper.getMainLooper())
    private var mUiThread: Thread? = null

    private var mediaPlayer: MediaPlayer? = null
    private var playing: Boolean = false
    private var countDownTimer: CountDownTimer? = null
    private lateinit var sharePrefs: SharePrefs
 //   private val apiRepository = ApiRepository()

    private lateinit var bindingFragmentHome: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        LanguageManager.updateResources(requireContext(), language.getLangCode())
        bindingFragmentHome = FragmentHomeBinding.inflate(layoutInflater)
        return bindingFragmentHome.root
        //return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharePrefs = SharePrefs(requireContext())
        if (sharePrefs.getTier() == "BASIC") {
            bindingFragmentHome.play.visibility = View.GONE
        } else {
            bindingFragmentHome.play.visibility = View.VISIBLE
        }
        /* G.T.
        val random = getRandom()
        if (sharePrefs.getTier() == "OKUDEN") {
            val okudenResID =
                resources.getIdentifier(
                    "res_${random}_okuden",
                    "raw",
                    requireContext().packageName
                )
            if (checkResourceExists(okudenResID)) {
                poem.text = HtmlCompat.fromHtml(
                    getPoem("${random}.Okuden").toString(),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            } else {
                poem.text = HtmlCompat.fromHtml(
                    getPoem(random.toString()).toString(),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        } else {
            poem.text = HtmlCompat.fromHtml(
                getPoem(random.toString()).toString(),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        }
        */

        bindingFragmentHome.poem.text = HtmlCompat.fromHtml(
            sharePrefs.getString(DAILY_POEM)!!,
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        bindingFragmentHome.play.setOnClickListener {
            playResource()
            playing = !playing
            changeButton()
        }
        countDownTimer = object : CountDownTimer(sharePrefs.getWaitPoemProgress() * 1000L, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                //println("---timer----$millisUntilFinished")
            }

            override fun onFinish() {
                if (context != null) {
                    playResource()
                    playing = !playing
                    changeButton()
                }
            }
        }
    }
    // G.T. Commented out because getting daily poem and song from server
/*
    private fun getRandom(): Int {
        //val todaysRandom = Random(Calendar.getInstance().get(DAY_OF_YEAR)).nextInt(1, 125)

        val cal = Calendar.getInstance(Locale.US)
        // 12/3/2020 -> cal.get(DAY_OF_YEAR)
        // API24: result 327
        // API30: result 338
        val seedNum: Long = (cal.get(YEAR)*400+cal.get(DAY_OF_YEAR)).toLong()
        println("----seed number----$seedNum")

        // G.T. new pseudo-random algorithm
        val LCRandom = LinearCongruentialRandomNumbers(seedNum)
        val todaysRandom = LCRandom.nextInt(125)+1
        println("----today's random----$todaysRandom")

        val sharedPref = requireActivity().applicationContext.getSharedPreferences(
            "poetry",
            Context.MODE_PRIVATE
        ) ?: return 1
        val lastSavedRandom = sharedPref.getInt("random", -1)
        val lastSavedDate = sharedPref.getString("date", "")
        val currentDateCal: String? = Calendar.getInstance().getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.LONG,
            Locale.getDefault()
        )

        val currentDate = currentDateCal + "_" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        return if (lastSavedDate != currentDate) {
            with(sharedPref.edit()) {
                putInt("random", todaysRandom.toInt())
                putString("date", currentDate)
                commit()
            }
            todaysRandom.toInt()
        } else lastSavedRandom
    }
 */
/* G.T.
    private fun getPoem(random: String) = when (language.getPoemsLang()) {
        "ja" -> Japanese.poems[random.toString()]
        "hu" -> Hungarian.poems[random.toString()]
        else -> Japanese.poems[random.toString()]
    }
*/
    private fun changeButton() {
        if (playing) bindingFragmentHome.play.setImageResource(R.drawable.ic_pause)
        else bindingFragmentHome.play.setImageResource(R.drawable.ic_play)
    }

    private fun play(/*resId: Int*/) {
        if (playing) {
            countDownTimer?.cancel()
            stopPlayer()
            return
        }
        try {
            if (mediaPlayer != null && mediaPlayer?.isPlaying == true) {
                mediaPlayer?.stop()
                mediaPlayer?.reset()
            }

            // G.T. Added for keep screen on when song repeat is turned on in settings
            if (sharePrefs.isPoemRepeat()) {
                requireActivity().window?.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            }
            /*
            val res = resources
            val inputStream = res.openRawResource(resId)
            val b = ByteArray(inputStream.available())
            inputStream.read(b)
            val str = String(b!!, Charsets.UTF_8)
            */
            val str = sharePrefs.getString(DAILY_SONG)

            val url = "data:audio/mp3;base64,$str"
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer()
            mediaPlayer?.setDataSource(url)
            mediaPlayer?.prepare()
            mediaPlayer?.start()
            setListener()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setListener() {
        mediaPlayer?.setOnCompletionListener {
            try {
                bindingFragmentHome.play.setImageResource(R.drawable.ic_play)
                if (sharePrefs.isPoemRepeat()) {
                    countDownTimer?.start()
                }
            } catch (exception: Exception) {
            }
            playing = false
        }
    }

    fun playResource() {
        if (bindingFragmentHome.play.isEnabled) {

            play()

            // G.T. old code
            /*
            //val random = getRandom()
            val random = sharePrefs.getInt(DAILY_POEM_NUMBER)

            if (sharePrefs.getTier() == "OKUDEN") {
                val okudenResID =
                    resources.getIdentifier(
                        "res_${random}_okuden",
                        "raw",
                        requireContext().packageName
                    )
                val resID =
                    resources.getIdentifier("res_${random}", "raw", requireContext().packageName)
                if (checkResourceExists(okudenResID)) {
                    play(okudenResID)
                    println("--playOkuden---")
                } else {
                    play(resID)
                    println("--normalOkuden---")
                }
            } else {
                val resID =
                    resources.getIdentifier("res_${random}", "raw", requireContext().packageName)
                play(resID)
            }
             */
        }
    }

    private fun checkResourceExists(resource: Int): Boolean {
        return resource != 0
    }

    private fun stopPlayer() {
        requireActivity().window?.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onPause() {
        countDownTimer?.cancel()
        stopPlayer()
        bindingFragmentHome.play.setImageResource(R.drawable.ic_play)
        super.onPause()
    }

    fun setOnResumePoem() {
        GetDailyPoemAndSong(bindingFragmentHome.poem)

        /*
        val random = getRandom()

        if (sharePrefs.getTier() == "OKUDEN") {
            val okudenResID =
                resources.getIdentifier(
                    "res_${random}_okuden",
                    "raw",
                    requireContext().packageName
                )
            if (checkResourceExists(okudenResID)) {
                poem.text = HtmlCompat.fromHtml(
                    getPoem("${random}.Okuden").toString(),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            } else {
                poem.text = HtmlCompat.fromHtml(
                    getPoem("$random").toString(),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }
        } else {
            poem.text = HtmlCompat.fromHtml(
                getPoem("$random").toString(),
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        }
        */
    }

    override fun onResume() {
        super.onResume()

        if (isVisible) setOnResumePoem()
    }

    private fun setPlayVisible(visible: Boolean) {
//        if (sharePrefs.getTier() != "BASIC") {
            if (visible)
                bindingFragmentHome.play.visibility = View.VISIBLE
            else
                bindingFragmentHome.play.visibility = View.GONE
//        }
    }

    private fun GetDailyPoemAndSong(objPoem: TextView) {
        //val url = AppConstants.BASE_URL

        this@HomeFragment.runOnUiThread(java.lang.Runnable {
            objPoem.text = resources.getString(R.string.refresh_poem)
            setPlayVisible(false)
        })

        var poem = ""
        var song = ""
        var poemNum = -1
        val email = sharePrefs.getString(AppConstants.EMAIL_LOGIN_FOR_SESSION)?.lowercase(Locale.ROOT)?.md5()
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
                    song = httpResponse.getString("dailySong")
                }

                sharePrefs.saveString(DAILY_SONG, song)
                sharePrefs.saveString(DAILY_POEM, poem)
                sharePrefs.saveInt(DAILY_POEM_NUMBER, poemNum)

                this@HomeFragment.runOnUiThread(java.lang.Runnable {
                    objPoem.text = HtmlCompat.fromHtml(poem, HtmlCompat.FROM_HTML_MODE_LEGACY)
                    setPlayVisible(true)
                })
            }
        })
    }
/*
    fun GetDailySong() {
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
                    sharePrefs.saveString(DAILY_SONG, song)
                }

                this@HomeFragment.runOnUiThread(java.lang.Runnable {
                    setPlayVisible(true)
                })
            }
        })
    }
 */

    private fun runOnUiThread(runnable: Runnable) {
        if (Thread.currentThread() != mUiThread) {
            mHandler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
