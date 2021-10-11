package org.techtown.person2

import android.widget.TextView

open class Person(open var name:String?) {
    var age:Int? = null
    var address:String? = null

    constructor(name:String?,age:Int?,adders:String?):this(name){
        println("Person의 생성자 호출됨")
        //this.name=name은 할필요가 없음 기본생성자파라미터에 넣어주니까 자동으로 생성됨
        this.age=age
        this.address=address
    }
    //파라미터로 UI객체를 전달 할 수 있다.
    //open을 붙여줘야 상속을 해도 좋다라는 뜻임.
    open fun walk(output:TextView){
        output.text="사람이 걷는다."
    }
}