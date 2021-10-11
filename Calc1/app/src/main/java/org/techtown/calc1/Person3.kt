package org.techtown.calc1

class Person3(var name:String?) {
    //클래스안에 넣은 변수는 속성이다.
    var age:Int? = null
    lateinit var  address:String

    /*사람의 이름을 전달하는 것은 이미 기본 생성자에서 하고 있는 역할이므로
    새로 추가한 생성자 함수에서는 사람 이름과 ㄴ아ㅣ를 파라미터로 전달받았습니다.
    그리고 this()를이용해 기본생성자를 호출합니다. 기본생성자를 호출할때 사람 이름을 파라미터로 넘기게 되어 있으므로
    전달받은 name파라미터의 값을 기본 생성자 호출 시 전달합니다. 이때문에
    this(name)코드가 만들어집니다.
     */
    constructor(name:String?, age:Int?):this(name){

    }
}