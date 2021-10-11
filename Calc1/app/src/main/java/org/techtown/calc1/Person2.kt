package org.techtown.calc1

class Person2 {
    //클래스안에 넣은 변수는 속성이다.
    var name:String? = null
    var age:Int? = null
    lateinit var  address:String

    constructor(){
        println("첫번째 생성자 호출됨")
    }
    constructor(name:String?){
        println("두번째 생성자 호출됨")
        this.name = name
    }
    constructor(name:String?,age:Int?,address:String){
        println("세번째 생성자 호출됨")
        this.name = name
        this.age= age
        this.address = address
    }
}