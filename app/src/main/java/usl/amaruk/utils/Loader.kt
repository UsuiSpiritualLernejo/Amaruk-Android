package usl.amaruk.utils

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import usl.R

class Loader(context: Context) {
    var popupWindow: PopupWindow? = null
    private lateinit var view: View

    init {
        if (popupWindow == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_loader, null, false)
            //val display = (context as Activity).windowManager.defaultDisplay
            //val size = Point()
            //display.getSize(size)
            val displayMetrics = context.resources.displayMetrics
            val width = displayMetrics.widthPixels
            val height = displayMetrics.heightPixels
            popupWindow = PopupWindow(view, width, height, true)
            popupWindow!!.isOutsideTouchable = false
            popupWindow!!.isFocusable = false
        }
    }

    fun alertShow() {
        try {
            if (popupWindow != null) {
                if (!popupWindow!!.isShowing) {
                    popupWindow?.showAtLocation(view, Gravity.CENTER, 0, 0)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun alertHide() {
        try {
            if (popupWindow != null) {
                if (popupWindow!!.isShowing) {
                    popupWindow!!.dismiss()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}