package org.techtown.controlflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //두개의 읽기변수상자를 만들고 자료형은 int으로 추론해줌
            val a = 10
            val b = 20
            var max:Int

            if (a > b){
                max = a
            } else {
                max = b
            }
            //if문 축약방법:중괄호 생략가능
            max = if (a > b) a else b

            //when문 사용하기
            when(max){
                10 ->{
                    println("max가 10 입니다.")
                }
                20 ->{
                    println("max가 20 입니다.")
                }
                30,40->{
                    println("max가 30이거나 40입니다.")
                }
                //범위지정
                in 50..60->{
                    println("max가 50부터 60까지 중하나입니다.")
                }
                else ->{
                    println("max가 10 도 아니고 20 도 아닙니다.")
                }
            }




        }
    }
}