package org.techtown.calc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val calc1 = Calc()
            val result = calc1.add(10, 10)

            output1.text = "더하기 결과 : ${result}"
        }
        button2.setOnClickListener {
            val calc = object : Calculator {
                //원타임 객체 인터페이스지만 객체를 만들 수 있다.
                override fun add(a: Int, b: Int): Int {
                    return a + b
                }
            }
            val calc1 = object : CalcAdapter() {
                //원타임 객체 추상클래스지만 객체를 만들 수 있다.
                override fun add(a: Int, b: Int): Int {
                    return a + b
                }
            }
        }
        button3.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) { //원타임객체
                println("버튼 클릭됨")
            }
        })
        //람다식 표현(축약)
        button3.setOnClickListener ({v->println("버튼 클릭됨")})
        button3.setOnClickListener() {v->println("버튼 클릭됨")}
        button3.setOnClickListener{v->println("버튼 클릭됨")}
        //계속 축약하다보니 우리가 쓰던것 처럼되는거임!
        button3.setOnClickListener{
            println("버튼 클릭됨")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}