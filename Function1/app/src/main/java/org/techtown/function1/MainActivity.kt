package org.techtown.function1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            show("안녕")
        }
        button2.setOnClickListener {
            val firstStr=input1.text.toString()
            val secondStr=input2.text.toString()

            val first=firstStr.toInt()
            val second=secondStr.toInt()

            val result = add(first, second) //함수 호출
            output1.text = "더하기 결과 :$result"
        }

        button3.setOnClickListener {
            val result=add(getFirst(),getSecond())
            output1.text="더하기 결과 : $result"

            //파라미터 이름으로 넣어주면 순서를 바꿔줘도 상관 없다.
            val result2 = add(a=10, b=10)
            //val result2 = add(b=10, a=10)
            val result3 = sum(10,20,30,40)
        }
        //주의 ! 버튼은 MainActivity클래스 안에 넣어줘야함
    }
    //variable arguments의 약자 vararg 들어오는수가 여러가지이면 쓴다.
    fun sum(vararg inputs:Int):Int{
        var output=0
        for(num in inputs){
            output = output + num
        }
        return output
    }
    fun getFirst():Int{
        val firstStr=input1.text.toString()
        return firstStr.toInt()
    }
    fun getSecond():Int{
        val secondStr=input1.text.toString()
        return secondStr.toInt()
    }

    //기본값 설정해주면 b값 안넣어줘도 알아서 0으로 들어감
    fun add(a:Int, b:Int=0):Int{
        return a + b
    }
    //함수 축약형
    fun add2(a:Int, b:Int):Int = a + b

    //함수 축약형 반환자료형을 추정해줘서 생략 할 수 있다.
    fun add3(a:Int, b:Int) = a+b

    fun show(message:String){
        println("버튼이 눌렸어요 : $message")
    }


}