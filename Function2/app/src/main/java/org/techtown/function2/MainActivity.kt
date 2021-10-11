package org.techtown.function2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //일반적인 함수 호출
            //var result =add(10,10)
            //람다식(익명의 함수)
            val addFunc = {a:Int , b:Int -> a+b}
            //val result=addFunc(10,10)
            val result =calc(10,10,addFunc)

            val addFunc2=getOperator("add")
            //물음표때문에 addFunc2가 오류나니까 !!두개를 써준것임 calc 파라미터에 랩핑을 안해줬으니까
            val result2=calc(20,20,addFunc2!!)

            output1.text = "결과 : $result"

            val multiply ={ a:Int,b:Int -> a+b}
            //val multiply2:(Int,Int)->Int={a:Int,b:Int->a+b}
            //자료형을 명시할수 있음 .앞에서 자료형을 명시해서 자료형을 유추할수 있어서 뒤에 a,b 타입은 생략가능
            val multiply2:(Int,Int)->Int={a,b -> a+b}

            //show()함수 람다식 표현
            //var show1={()->println("show함수 호출됨.)"}을 밑에 처럼 쓸수 있음
            var show1 ={println("show함수 호출됨.")}
            //자료형 명시, 함수를 반환하는데 자료형은 Unit이다.
            var show2:()->Unit ={println("show함수 호출됨.")}

            //익명의 함수 생성
            val sum= fun(a:Int,b:Int):Int{
                return a + b
            }
            sum(10,10)

            //함수 호출
            doAction(fun(){
                println("전달된 함수 호출됨.")
            })
            doAction2(fun():Int{
                println("전달된 함수 호출됨.")
                return 10
            })
            //람다식으로 축약
//            doAction2(){->
//                println("전달된 함수 호출됨.")
//                10 //숫자만 써도 리턴값으로 취급함
//            }
            //()와 -> 생략가능
            doAction2{
                println("전달된 함수 호출됨.")
                10 //람다식안에서는 숫자만 쓰는것을 리턴값으로 취급함
            }
            //명확하게 반환하고 싶은 경우
            doAction2{
                println("전달된 함수 호출됨.")
                return@doAction2 10
            }
        }

    }
    fun doAction(action:()->Unit){
        println("doAction 호출됨.")
        action()
    }
    fun doAction2(action:()->Int){
        println("doAction2 호출됨")
        val result = action()
    }
    //리턴값이 없으면 자바는 void처럼 코틀린에서는 Unit을 사용한다.
    fun show():Unit{
        println("show 함수 호출됨.")
    }

    //반환되는것이 함수인 경우
    fun getOperator(name:String):((Int,Int)->Int)? {
        //함수를 null로 만들수있게하려면 ?를 써주면된다.
        var oper: ((Int, Int) -> Int)? = null
        //더하기 함수생성
        if (name == "add") {
            oper={ a: Int, b: Int -> a + b }
        }
        //빼기 함수생성
        else if(name=="subtract") {
            oper = { a: Int, b: Int -> a - b }
        }
        return oper
    }
    //함수상자의 이름이 oper이라고 둔거임
    //더하기 함수가 oper파라미터에 전달되었다면 더하기함수가 실행되는 거임
    fun calc(first:Int, second:Int, oper:(Int,Int)->Int):Int{
        return oper(first, second)
    }

    /*
    fun add(a:Int, b:Int):Int{
        return a+b
    }
    */
    //축약형 함수
    //fun add(a:Int,b:Int):Int=a+b
    //fun add(a:Int,b:Int)=a+b
}