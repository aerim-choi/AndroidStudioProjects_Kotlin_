package org.techtown.intropage

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveButton.setOnClickListener(){
            var intent= Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }
        //최초실행여부를 판단
        var pref:SharedPreferences =getSharedPreferences("checkFirst", Activity.MODE_PRIVATE)
        var checkFirst:Boolean=pref.getBoolean("checkFirst",false)

        if(checkFirst==false){
            //앱 최초 실행시 하고 싶은 작업
            var editor:SharedPreferences.Editor=pref.edit()
            editor.putBoolean("checkFirst",true)
            editor.commit()

            intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            //최초실행이 아닐때 작업
        }

    }

}