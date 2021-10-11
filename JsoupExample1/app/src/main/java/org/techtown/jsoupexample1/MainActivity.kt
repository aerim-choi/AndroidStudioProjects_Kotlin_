package org.techtown.jsoupexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import org.jsoup.Jsoup
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retrieveWebInfo()

    }

    private fun retrieveWebInfo(){
        thread{
            // network call, so run it in the background
            val doc =
                Jsoup.connect("https://www.tutorialspoint.com/android/index.htm")
                    .get()

            val imageElements = doc.getElementsByClass("img-responsive")
            val textElements = doc.getElementsByTag("h1")

            val imageUrl = imageElements[0].absUrl("src")

            // can't access UI elements from the background thread
            this.runOnUiThread{
                txtTitle.text = textElements[0].text()
                Picasso.get().load(imageUrl).into(imgTitle)

            }
        }
    }
}