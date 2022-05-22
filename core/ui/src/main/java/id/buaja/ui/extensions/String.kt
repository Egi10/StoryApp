package id.buaja.ui.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Julsapargi Nursam on 5/22/22.
 * Mobile Engineer - Android
 */

fun String.getInitials(): String {
    var str = this.trim()
    str = str.replace("\\s+".toRegex(), " ")
    str = str.uppercase(Locale.getDefault())

    if (str.isEmpty()) {
        return "-"
    }

    if (str.length <= 2) {
        return str
    }

    var result: String = str[0].toString()

    val token = str.split(" ")
    if (token.size >= 2) {
        // Get Last Name
        val second = token[1][0]
        result += second
    } else if (this.length >= 2) {
        // If no last name, use second character of first name
        val second = str[1].toString()
        result += second
    }

    return result
}

fun String.formatDate(): String {
    val simpleFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val simpleFormatOut = SimpleDateFormat("yyyy/MM/dd HH:mm a", Locale.getDefault())

    val dateIn = simpleFormat.parse(this)
    val dateOut = dateIn?.let { simpleFormatOut.format(it) }

    return dateOut ?: ""
}