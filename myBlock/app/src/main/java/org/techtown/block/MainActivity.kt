package org.techtown.block

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            val person1 = Person()
            person1?.name="홍길동1"
            person1?.age=20
            person1?.mobile="010-1000-1000"
            //apply코드블럭하여 간결하게 작성할 수 있음
            val person2:Person? =Person().apply {
                name="홍길동1"
                age=20
                mobile="010-1000-1000"
            }

            showToast("이름 : ${person2?.name}")
            showToast("나이 : ${person2?.age}")
            showToast("전화번호 : ${person2?.mobile}")
            //with코드블럭을 사용하여 간결하게 작성할 수 있음
            //!!를 해줘야 밑에 name만 써도 오류안남 위에서 널값도 가능하게 정의해놨으니까
            with(person2!!){
                showToast("이름 : $name")
                showToast("나이 : $age")
                showToast("전화번호 : $mobile")
            }
            if (person2 !=null){
                showToast("이름 : ${person2.name}")
                showToast("나이 : ${person2.age}")
                showToast("전화번호 : ${person2.mobile}")
            }else{
                showToast("사람객체가 널입니다.")
            }
            //널이아니라는 뜻이 ?.임
            //let코드 블럭을 사용하여 간결하게 작성할 수 있음
            person2?.let{
                showToast("이름 : ${it.name}")
                showToast("나이 : ${it.age}")
                showToast("전화번호 : ${it.mobile}")
            }?:run{
                showToast("사람객체가 널입니다.")
            }
            //run은 객체의 속성앞에 아무것도 안붙여도 속성을 바로사용할수있다
            person2?.run{
                showToast("이름 : $name")
                showToast("나이 : $age")
                showToast("전화번호 : $mobile")
            }?:run{
                showToast("사람객체가 널입니다.")
            }
            val person3=Person()
            if(person3.name==null){
                showToast("사람 객체의 name 속성이 널입니다.")
            }
            if(person3.age==null){
                showToast("사람 객체의 age 속성이 널입니다.")
            }

            val person4=Person()

            //also코드블럭은 반환도 가능하고 만들어졌던 객체의 속성도 바꿔줄수있다.
            val person5 = person4.also{
                if(it.name==null){
                    showToast("사람 객체의 name 속성이 널입니다.")
                }
                it.name="홍길동4"
                if(it.age==null){
                    showToast("사람 객체의 age 속성이 널입니다.")
                }
                it.age=21
            }



        }
    }
    fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}