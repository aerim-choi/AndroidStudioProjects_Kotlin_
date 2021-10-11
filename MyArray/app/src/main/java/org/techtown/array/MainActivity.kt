package org.techtown.array

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val names = arrayOf("홍길동1","홍길동2","홍길동3")
            //홍길동${index+1}값으로 초기화 된다는것임임
            val names2 = Array<String>(3,{index -> "홍길동${index+1}"})
            //null값을 저장하고 싶을 때
            val names3 = arrayOfNulls<String>(3)
            //빈배열
            val names4 = emptyArray<String>()

            output1.append("\nnames : ${Arrays.toString(names)}")
            output1.append("\nnames : ${Arrays.toString(names2)}")
            output1.append("\nnames : ${Arrays.toString(names3)}")
            output1.append("\nnames : ${Arrays.toString(names4)}")

            val digits=intArrayOf(1, 2, 3)
            // 인덱스2번을 4로 바꿔보자
            //digits.set(2,4)
            digits[2] = 4
            //val aDigit=digits.get(2)
            val aDigit=digits[2]
            //배열의 크기를 구할때는 count()나 size를 사용할 수 있다.
            val digitCount=digits.count()
            val digitSize=digits.size
            output1.append("\ndigits배열 크기: $digitCount")
            output1.append("\ndigits배열 크기: $digitSize")

            val digits2 = digits.plus(5)
            //5가 몇번째 인덱스에 들어가 있냐
            val aIndex=digits2.indexOf(5)
            //aIndex의 값은 3임
            //인덱스 범위지정(인덱스값 1부터 3인 배열반환)
            val digits3 = digits2.sliceArray(1..aIndex)
            //Arrays.toString(digits3)보다 digits3.contentToString을 더권장한다.
            output1.append("\n배열3: ${digits3.contentToString()}")

            //forEachIndexed는 배열의 값과 인덱스값을 알려줌
            digits.forEachIndexed { index, i ->
                output1.append("\n#${index}:${i}")
            }
            //forEachIndexed를 쓰지 않을경우
            var elemIndex = 0
            for (elem in digits){
                output1.append("\n#${elemIndex}:${elem}")
                elemIndex += 1
            }
            //iterator()사용 하는 경우
            val iter=digits.iterator()
            elemIndex = 0
            //iter의 다음값이 있으면 실행 없으면 실행x
            //iterator()을 사용하는이유 다른개발자가 내코드 보기편함.
            while(iter.hasNext()){
                val elem= iter.next()
                output1.append("\n#${elemIndex}:${elem}")
                elemIndex += 1
            }
            //정렬
            //오름차순
            val sortedArray = digits.sortedArray()
            //내림차순
            val sortedArray2 = digits.sortedArrayDescending()
            //필터메소드 필터링된 원소를 보여준다.
            digits.filter {elem -> elem> 1 }.forEach{
                output1.append("\n원소 : $it")
            }
        }
        button2.setOnClickListener {
            val names = listOf("홍길동1","홍길동2","홍길동3")
            //val names2= List<String>(3,{index -> "홍길동${index+1}"})
            //권장하는 방법
            val names2= List<String>(3){index -> "홍길동${index+1}"}
            //기존 리스트는 변경이 불가한데(이뮤터블) 뮤터블리스트는 변경이 가능하다
            val names3= mutableListOf<String>("홍길동1","홍길동2","홍길동3")
            //빈 리스트 생성
            val names4=emptyList<String>()
            //arrayListOf와 ArrayList를 많이 쓴다(뮤터블 이뮤터블 헷갈리니까)
            val names5=arrayListOf<String>()
            val names6=ArrayList<String>()
            //리스트 원소 추가 ,변경 방법
            names3.add("홍길동4")
            names3[1]="홍길동5"
            output1.append("\n${names3.joinToString()}")
            //리스트안에 홍길동 5가 있는지
            if(names3.contains("홍길동5")){
                val aIndex = names3.indexOf("홍길동5")
                //잘라내기
                val names4 = names3.slice(0..aIndex)
                output1.append("\n${names4.joinToString()}")
            }


        }


    }
}