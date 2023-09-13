package usl.amaruk.utils

import androidx.core.text.HtmlCompat
import java.math.BigInteger
import java.security.MessageDigest


fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.bold() : String{
    val sourceString = "<b>"+ this +"</b>"
    return HtmlCompat.fromHtml(sourceString, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
}