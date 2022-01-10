package scrooge.my.apptest.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


object UtilFunction {

    fun capitalizeName(name: String): String {
        val nameLowerCase = name.toLowerCase()
        return nameLowerCase.capitalize()
    }

    fun parsingDate(string: String): String {
        return if (string.isNotEmpty()) {
            val sdfInput = SimpleDateFormat("yyyy-MM-dd")
            val sdfOutput = SimpleDateFormat("dd.MM.yyyy")
            val date = sdfInput.parse(string)
            val stringParsingData = sdfOutput.format(date)

            stringParsingData
        } else "--"
    }

    fun getAge(dobString: String): String {
        var date: Date? = null
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        try {
            date = sdf.parse(dobString)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        if (date == null) return "--"
        val dob: Calendar = Calendar.getInstance()
        val today: Calendar = Calendar.getInstance()
        dob.setTime(date)
        val year: Int = dob.get(Calendar.YEAR)
        val month: Int = dob.get(Calendar.MONTH)
        val day: Int = dob.get(Calendar.DAY_OF_MONTH)
        dob.set(year, month + 1, day)
        var age: Int = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--
        }
        return age.toString()
    }
}