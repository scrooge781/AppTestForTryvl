package scrooge.my.apptest.util

import android.os.Build
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object UtilFunction {

    fun capitalizeName(name: String): String {
        val nameLowerCase = name.toLowerCase()
        return nameLowerCase.capitalize()
    }

    fun parsingDate(string: String): String {
        return if (string.isNotEmpty()) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val data = LocalDate.parse(string, firstApiFormat)

                "${data.dayOfMonth}.${data.monthValue}.${data.year}"
            } else {
                "--"
            }
        } else "--"
    }
}