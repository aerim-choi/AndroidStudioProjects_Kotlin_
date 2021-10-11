package org.techtown.inflater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //layout part1을id가 container부분에 true하면 바로 붙여주겠다.
            layoutInflater.inflate(R.layout.part1,container,true)
        }

    }
}