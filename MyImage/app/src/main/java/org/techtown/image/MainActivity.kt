package org.techtown.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_MOVE
import android.widget.FrameLayout
import androidx.core.view.marginTop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var startX = 0.0f
    var startY = 0.0f

    var leftMargin = 0
    var topMargin = 0

    var carWidth=0.0f
    var carHeight=0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carWidth= resources.getDimension(R.dimen.car_width)
        carHeight=resources.getDimension(R.dimen.car_height)

        carImageView.setOnTouchListener { v, event ->
            when(event.action){
                MotionEvent.ACTION_DOWN->{
                    println("손가락 눌림.")
                    //눌렸을때 화면의 x좌표를 event.x라고함
                    startX= event.x
                    startY= event.y
                }
                MotionEvent.ACTION_MOVE-> {
                    println("손가락 움직임.")

                    val diffX=event.x-startX
                    var diffY=event.y-startY

                    leftMargin+=diffX.toInt()
                    topMargin+=diffY.toInt()
                    //carImageView.marginTop은 읽기전용 변수라 바꿀수 없음
                    //그러므로 layoutParams로 바꿔줘야한다.
                    //레이아웃 가로크기,세로크기 파라미터
                    //이런식으로 마진값을 바꿔줘야함
                    val layoutParams=FrameLayout.LayoutParams(
                        carWidth.toInt(),
                        carHeight.toInt()
                    )

                    layoutParams.leftMargin=leftMargin
                    layoutParams.topMargin=topMargin
                    carImageView.layoutParams=layoutParams

                }
                MotionEvent.ACTION_UP-> {
                    println("손가락 뗌.")



                }
            }
            true//람다식 리턴값
            //return@setOnTouchListener true 라고 해도됨
        }

    }
}