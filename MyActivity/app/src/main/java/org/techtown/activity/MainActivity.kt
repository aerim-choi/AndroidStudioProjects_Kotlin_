package org.techtown.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showButton.setOnClickListener {
            //새로운 화면 띄우기
            val showIntent=Intent(this,MenuActivity::class.java)
            showIntent.putExtra("mobile","010-1000-1000")
            startActivityForResult(showIntent,101)
        }
        showToast("onCreate 호출됨")

        saveButton.setOnClickListener {
            val input1 = input1.text.toString()
            //보안때문에 private를 일반적으로 쓴다
            val pref = getSharedPreferences("pref", MODE_PRIVATE)
            //여러개의 함수를 한번에 실행하라는게 commit임
            //pref.edit().putString("userName",input1).commit()
            //같은뜻인데 이코드를 더 권장한다.
            pref.edit{
                putString("userName",input1)
                commit()
            }
        }
        loadButton.setOnClickListener {
            val pref=getSharedPreferences("pref", MODE_PRIVATE)
            val userName = pref.getString("userName","")
            input1.setText(userName)

        }


    }
    override fun onStart() {
        super.onStart()
        showToast("onStart 호출됨")
    }

    override fun onResume() {
        super.onResume()
        showToast("onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        showToast("onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        showToast("onStop 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        showToast("onDestroy 호출됨")
    }

    //화면 구분코드를 requestCode, resultCode:값을 전달할수있는데그게 정상인지아닌지 구분
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            101 -> {
                showToast("메뉴 액티비티에서 응답 받았음: $requestCode,$resultCode")
                if(data!=null){
                    processIntent(data)
                }
            }
        }
    }
    fun processIntent(passedIntent: Intent){
        val data=passedIntent.getStringExtra("data")
        if(data!=null){
            showToast("메뉴 액티비티로부터 전달받은 데이터 : $data ")
        }
    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
    }

}