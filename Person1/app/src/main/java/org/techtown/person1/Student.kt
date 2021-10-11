package org.techtown.person1

class Student(var alias:String?) : Person(alias){

    constructor(alias:String?,age:Int?,address:String?):this(alias){
        println("Student 생성자 호출됨")

        this.age=age
        this.address=address
    }
}