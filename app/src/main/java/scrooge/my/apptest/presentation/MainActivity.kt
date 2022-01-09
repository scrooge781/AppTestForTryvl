package scrooge.my.apptest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import scrooge.my.apptest.R
import scrooge.my.apptest.data.model.Response
import scrooge.my.apptest.data.remote.ParsingJson
import java.io.IOException
import java.lang.reflect.Type
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var parsingJson: ParsingJson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("test ${parsingJson.getAssetJsonData()?.response.toString()}")
    }

}