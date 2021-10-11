package org.techtown.person2

class Student2 :Person {
    //this는 나자신 super은 부모
    constructor(alias:String?,age:Int?,address:String?):super(alias){
        println("Student2 생성자 호출됨")

        this.age=age
        this.address=address
    }
}
