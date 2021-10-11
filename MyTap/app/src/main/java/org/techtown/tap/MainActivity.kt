package org.techtown.tap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager.beginTransaction()){
            var first = FirstFragment()
            replace(R.id.container,first).commit()
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.tap1 ->{
                    with(supportFragmentManager.beginTransaction()){
                        var first = FirstFragment()
                        replace(R.id.container,first).commit()
                    }
                }
                R.id.tap2 ->{
                    with(supportFragmentManager.beginTransaction()){
                        var second = SecondFragment()
                        replace(R.id.container,second).commit()
                    }
                }
                R.id.tap3 ->{
                    with(supportFragmentManager.beginTransaction()){
                        var third = ThirdFragment()
                        replace(R.id.container,third).commit()
                    }
                }
            }
            return@setOnNavigationItemSelectedListener true
        }



    }
}