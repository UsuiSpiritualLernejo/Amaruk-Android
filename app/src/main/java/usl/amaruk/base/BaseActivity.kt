package usl.amaruk.base

import android.app.Activity
import android.content.Intent
//import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
//import usl.amaruk.language
import java.util.*

open class BaseActivity : AppCompatActivity() {

    fun refreshActivity(reloadingActivity: Activity) {
        val intent =
            Intent(this, reloadingActivity.javaClass).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        this.overridePendingTransition(0, 0)
        this.startActivity(intent)
        this.overridePendingTransition(0, 0)
    }


}