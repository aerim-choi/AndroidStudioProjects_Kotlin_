package org.techtown.person2

import android.widget.TextView

class Student(override var name:String?) : Person(name){

    constructor(name:String?,age:Int?,address:String?):this(name){
        println("Student 생성자 호출됨")

        this.age=age
        this.address=address
    }
    //파라미터로 UI객체를 전달 할 수 있다.
    //부모의 함수를 다시 정의하겠다. override를 써준다.
    override fun walk(output: TextView){
        //부모의 함수도 출력하고싶으면(사람이 걷는다)
        //super.walk(output)
        output.text="학생이 걷는다."
    }
}