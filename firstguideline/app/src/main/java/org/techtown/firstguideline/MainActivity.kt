package org.techtown.firstguideline

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var prefs:SharedPreferences = getSharedPreferences("Pref", MODE_PRIVATE)// 선언&생성

        fun checkFirstRun() {
            var isFirstRun:Boolean = prefs.getBoolean("isFirstRun", true)
            if (isFirstRun) {
                val newIntent = Intent(this, GuideActivity::class.java)
                startActivity(newIntent)

                prefs.edit().putBoolean("isFirstRun", false).apply()
            }

        }
    }
}


