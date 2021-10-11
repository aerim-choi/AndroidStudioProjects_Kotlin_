package org.techtown.customlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.part1.*
import kotlinx.android.synthetic.main.part1.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageResource(R.mipmap.ic_launcher)
        button.setOnClickListener {
            view.output1.text="홍길동1"
            view.output2.text="010-1000-1000"
        }
        button2.setOnClickListener {
            imageView.setImageResource(R.drawable.user)
        }
    }
}