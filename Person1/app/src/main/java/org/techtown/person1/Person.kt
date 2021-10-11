package org.techtown.person1

open class Person(var name:String?) {
    var age:Int? = null
    var address:String? = null

    constructor(name:String?,age:Int?,adders:String?):this(name){
        println("Person의 생성자 호출됨")
        //this.name=name은 할필요가 없음 기본생성자파라미터에 넣어주니까 자동으로 생성됨
        this.age=age
        this.address=address
    }
}