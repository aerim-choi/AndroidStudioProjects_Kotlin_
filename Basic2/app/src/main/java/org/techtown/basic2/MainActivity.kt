package org.techtown.basic2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var name:String? = null
    lateinit var mobile:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //랩으로 감쌌기때문에바로 length를 알 수 없다.
            //name.length
            //그래서 !!를 붙여줘야한다.
            //val nameLength=name!!.length
            //근데 오류남 안에 null이 있기때문
            //?을 붙이면 null이 있지 않을때만 처리하는거임
            //val nameLength=name?.length
            //널일경우에는 0 , 널이아닐경우에는 name.length를 사용한다.
            val nameLength=name?.length ?:0
           // name = nameInput.text.toString()
           // mobile = mobileInput.text.toString()

            //Toast.makeText(applicationContext,"이름 : $name, 전화번호 : $mobile ", Toast.LENGTH_LONG).show()
        }
    }

}