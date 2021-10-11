package org.techtown.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        backButton.setOnClickListener{
            val backIntent=Intent()
            backIntent.putExtra("data","홍길동")
            //인텐트가 이전화면으로 전달된다.
            setResult(201,backIntent)
            //현재창을 닫아달라
            finish()
        }
        //널체크
        if(intent != null){
            processIntent(intent)
        }

    }
    fun processIntent(passedIntent: Intent){
        val mobile = passedIntent.getStringExtra("mobile")
        if (mobile != null){
            showToast("전달받은 값 : $mobile")
        }
        /*
        위랑 같은뜻 mobile이라는 객체가 null이 아닐경우에 중괄호안에 코드를 실행시켜라
        mobile?.run{
            showToast("전달받은 값 : $mobile")
        }
        */

    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
    }
}