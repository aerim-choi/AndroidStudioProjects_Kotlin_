package org.techtown.basic3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
//패키지 변수(바깥에 클래스없이도 변수 쓰면 자동으로 import되서 바로 사용가능하다.)
import org.techtown.basic3.constants.mBonus

class MainActivity : AppCompatActivity() {
    var first:Int = 0
    var second:Int = 0

    companion object{
        val BONUS = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener {
            val firstStr = input1.text.toString()
            val secondStr = input2.text.toString()

            first = firstStr.toInt()
            second = secondStr.toInt()

            val result= first + second + MainActivity.BONUS + mBonus
            output1.text= "결과 :  $result"

            if(result == 20){
                output1.text="더하기 결과가 20입니다."
            }
            if(firstStr == "10"){
                output1.append("\n첫번째 입력된 값이 10 입니다.")
            }
            //Any를 쓰면 글자나 숫자나 어떤것이나 들어갈수 있다.
            val input1:Any = "안녕"
            val input2:Any = 10

            if(input1 is String){
                //형변환:as String으로 써주면 변수상자가 Any에서 String크기로 바뀌는 것이다.
                val output2:String = input1 as String
                output1.text="input1은 문자열 자료형입니다."
            }
            //랩핑: 랩으로 한번 감싸주겠다
            val output3:String? = input1 as String?

        }
    }
}