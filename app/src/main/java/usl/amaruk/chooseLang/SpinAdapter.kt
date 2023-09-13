package usl.amaruk.chooseLang

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import usl.R


class SpinAdapter(private val mContext: Context, private val languageList: ArrayList<LanguageItem>): BaseAdapter() {
    override fun getCount(): Int {
      return languageList.size
    }

    override fun getItem(p0: Int): Any {
     return p0
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup?): View {
       val languageItem:LanguageItem = languageList[i]
        val inflater:LayoutInflater= (mContext as Activity).layoutInflater
        val view:View = inflater.inflate(R.layout.item_spinner_lang, viewGroup, false)
        val tvLangName = view.findViewById<TextView>(R.id.tvLangName)
        val ivLangIcon = view.findViewById<ImageView>(R.id.ivLangIcon)

        tvLangName.text = languageItem.name
        ivLangIcon.setImageResource(languageItem.image)

        return view
    }

}