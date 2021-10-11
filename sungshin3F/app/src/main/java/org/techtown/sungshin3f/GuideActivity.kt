package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_guide.*

// 다운로드한 후 처음 실행하면 뜨는 어플 메뉴얼화면입니다.
class GuideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        pager.adapter =PagerAdapter(this)
        pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit = 3

        indicator.setViewPager(pager)
        //indicator 3개만들고 첫번째꺼를 보여준다.
        indicator.createIndicators(3,0)

        pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                showToast("페이지 선택: ${position}")
                indicator.animatePageSelected(position)
            }
        })

    }
    fun showToast(message:String){
        Toast.makeText(applicationContext,message, Toast.LENGTH_LONG).show()
    }
    inner class PagerAdapter : FragmentStateAdapter {
        //생성자
        constructor(activity: FragmentActivity):super(activity)
        //아이템이 몇개있냐
        override fun getItemCount()=3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->{
                    GuideFragment1()
                }
                1->{
                    GuideFragment2()
                }
                2->{
                    GuideFragment3()
                }
                else->{
                    GuideFragment1()
                }
            }
        }
    }

}
