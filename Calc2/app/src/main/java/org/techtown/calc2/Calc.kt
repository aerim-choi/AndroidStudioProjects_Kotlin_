package org.techtown.calc2
//인터페이스를 구현한다 :적고 인터페이스 이름적는다.
class Calc : Calculator{
    //인터페이스도 override를 적어줘야한다.(함수재정의)
    override fun add(a:Int, b:Int) = a + b

    fun subtract(a:Int, b:Int)= a - b

    fun multiply(a:Int, b:Int)= a * b

    fun divide(a:Int, b:Int)= a / b
}
