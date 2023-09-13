package usl.amaruk

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.annotation.NonNull
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBarDrawerToggle
//import kotlinx.android.synthetic.main.activity_main.*
//import kotlinx.android.synthetic.main.fragment_info.view.*
//import kotlinx.android.synthetic.main.nav_header.view.*
import usl.R
import usl.amaruk.base.BaseActivity
import usl.amaruk.base.LocaleUtils
import usl.amaruk.prefs.SharePrefs
import usl.amaruk.utils.LanguageManager
import usl.amaruk.view.WalkUpdateView
import usl.databinding.ActivityMainBinding
import usl.databinding.FragmentInfoBinding
import usl.databinding.NavHeaderBinding
import java.util.*

class MainActivity : BaseActivity(), WalkUpdateView {

    lateinit var dl: DrawerLayout
    private lateinit var t: ActionBarDrawerToggle
    private lateinit var sharePrefs: SharePrefs
    lateinit var nv : NavigationView

    private lateinit var bindingActivityMain: ActivityMainBinding
//    private lateinit var bindingFragmentInfo: FragmentInfoBinding
//    private lateinit var bindingNavHeader: NavHeaderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LanguageManager.updateResources(this, language.getLangCode())
/*
        bindingFragmentInfo = FragmentInfoBinding.inflate(layoutInflater)
        val viewFragmentInfo = bindingFragmentInfo.root

        bindingNavHeader = NavHeaderBinding.inflate(layoutInflater)
        val viewNavHeader = bindingNavHeader.root
*/
        bindingActivityMain = ActivityMainBinding.inflate(layoutInflater)
        val viewActivityMain = bindingActivityMain.root
        setContentView(viewActivityMain)

        //setContentView(R.layout.activity_main)

        sharePrefs = SharePrefs(this)
        initMenu()
        invalidateOptionsMenu()

/*
        if (sharePrefs.isPoemRepeat()) {
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        }
*/
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.root_layout, getBaseFragment(), "home")
            .commit()

        bindingActivityMain.home.setOnClickListener {
            replaceFragment(HomeFragment(), resources.getString(R.string.poems_for_day))
        }

        setToolbarTitle(resources.getString(R.string.poems_for_day))
        setLabels()
    }

    private fun getBaseFragment(): Fragment = HomeFragment()

    fun replaceFragment(fragment: Fragment, title: String) {

        dl.closeDrawers()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, fragment, fragment.javaClass.name)
            .commit()

        setToolbarTitle(title)
        setLabels()
    }

    private fun hideHome() {
        bindingActivityMain.home.visibility = View.INVISIBLE
    }

    fun showHome() {
        bindingActivityMain.home.visibility = View.VISIBLE
    }

    fun setToolbarTitle(title: String) {
       bindingActivityMain.toolbarTitle.text = title
    }

    private fun setLabels() {
        val nv = findViewById<NavigationView>(R.id.nv)
        val headerView = nv.getHeaderView(0)

        headerView.findViewById<TextView>(R.id.side_header_title).text = LocaleUtils.getString(applicationContext, R.string.app_name)
        headerView.findViewById<TextView>(R.id.userName).text = sharePrefs.getFullName()
        headerView.findViewById<TextView>(R.id.userEmail).text = sharePrefs.getEmailAddress()
    }

    // G.T. Show menu item "About Us" only for tier BASIC
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        bindingActivityMain.nv.menu.findItem(R.id.about).isVisible = (sharePrefs.getTier() == "BASIC")
        //menuInflater.inflate(R.menu.nav, menu)
        return true
    }

    private fun initMenu() {
        dl = findViewById(R.id.activity_main)
        t = ActionBarDrawerToggle(this, dl, R.string.app_name, R.string.app_name)
        dl.addDrawerListener(t)
        t.syncState()

        /*
        nv = findViewById<NavigationView>(R.id.nv)
        nv.getHeaderView(0).side_header_title.text =
            LocaleUtils.getString(applicationContext, R.string.app_name)
        nv.getHeaderView(0).user_name.text = sharePrefs.getFullName()
        nv.getHeaderView(0).user_email.text = sharePrefs.getEmailAddress()
        */
        bindingActivityMain.nv.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.poems -> {
                        replaceFragment(HomeFragment(),
                            resources.getString(R.string.poems_for_day))
                    }
                    R.id.how -> {
                        replaceFragment(
                            HowToFragment(),
                           resources.getString(R.string.nav_use)
                        )
                    }
                    R.id.settings -> {
                        replaceFragment(
                            SettingsFragment(),
                            resources.getString(R.string.nav_settings)
                        )
                    }
                    R.id.about -> {
                        replaceFragment(
                            AboutFragment(),
                            resources.getString(R.string.nav_about)
                        )
                    }
                    R.id.logout -> {
                        openLogOutDialog(this@MainActivity)
                    }
                    else -> return true
                }
                return true
            }
        })
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun showMessage(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (t.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }

    private fun openLogOutDialog(context: Context?){
        val dialog = Dialog(context!!, R.style.full_screen_dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.log_out_dialog)
        val window: Window? = dialog.window
        val wlp = window?.attributes

        wlp?.gravity = Gravity.CENTER
        window?.attributes = wlp
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val yesTv : TextView = dialog.findViewById(R.id.yesTv)
        val noTv : TextView = dialog.findViewById(R.id.noTv)

        yesTv.setOnClickListener {
            dialog.dismiss()
            sharePrefs.rememberMe(false)
            language.clearPoemLang()
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
        noTv.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
