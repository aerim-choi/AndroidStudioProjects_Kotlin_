package org.techtown.customlayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
//Part1클래스 생성
class Part1 :LinearLayout {
    //생성자 정의
    constructor(context: Context?) : super(context){
        onInit(context)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        onInit(context)
    }

    fun onInit(context:Context?){
        LayoutInflater.from(context).inflate(R.layout.part1,this,true)
    }
}