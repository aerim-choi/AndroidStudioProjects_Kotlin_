package org.techtown.calc1

class Person(var name:String?){
    //var name:String이 파라미터 처럼 넣어주지만 사실 속성인거임.
    //그래서 언제든 Person객체에서 name을 사용할 수 있다.
    var age:Int? = null
    lateinit var address:String
    //기본생성자 호출시점에 init코드블럭 안에 코드를 자동으로 실행시켜줌
    init{
        println("생성자가 호출됨")
    }
}