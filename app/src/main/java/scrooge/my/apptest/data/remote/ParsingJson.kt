package scrooge.my.apptest.data.remote

import android.content.Context
import android.util.Log
import java.io.IOException
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import scrooge.my.apptest.data.model.Response

import java.lang.reflect.Type


class ParsingJson(val context: Context) {

    companion object {
        private const val NAME_JSON = "specialist.json"
    }

        fun getAssetJsonData(): Response? {
            val json: String
            try {
                val inputStream = context.assets.open(NAME_JSON)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.use { it.read(buffer) }
                json = String(buffer)
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            // print the data
            Log.i("data", json)

            val type: Type = object : TypeToken<Response?>() {}.type

            return Gson().fromJson(json, type)
        }

}