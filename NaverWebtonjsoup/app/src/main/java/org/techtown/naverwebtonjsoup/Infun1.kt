package org.techtown.naverwebtonjsoup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_new_webtoon.*
import kotlinx.android.synthetic.main.webtoon_item.*
import org.jsoup.Jsoup
import org.techtown.naverwebtonjsoup.databinding.ActivityInfun1Binding

import kotlin.concurrent.thread

class Infun1 : AppCompatActivity() {

    private var mBinding:ActivityInfun1Binding?=null
    private val binding get()=mBinding!!

    companion object{
        lateinit var newWebtoonImg1:String
        lateinit var newWebtoonImg2:String
        lateinit var newWebtoonImg3:String
        lateinit var newWebtoonTitle1:String
        lateinit var newWebtoonTitle2:String
        lateinit var newWebtoonTitle3:String
        lateinit var newWebtoonWriter1:String
        lateinit var newWebtoonWriter2:String
        lateinit var newWebtoonWriter3:String
        lateinit var newWebtoonCon1:String
        lateinit var newWebtoonCon2:String
        lateinit var newWebtoonCon3:String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityInfun1Binding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.pager.adapter =PagerAdapter(this)
        binding.pager.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.offscreenPageLimit=3

        binding.pager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
        binding.infun1RecBtn.setOnClickListener {
            binding.pager.currentItem = 0
        }
        binding.infun1NewBtn.setOnClickListener {
            binding.pager.currentItem = 1
        }
        binding.infun1GenBtn.setOnClickListener {
            binding.pager.currentItem = 2
        }

        NewWebtoonInfo()


    }
    private fun NewWebtoonInfo(){
        thread{
            val doc= Jsoup.connect("https://comic.naver.com/webtoon/weekday")
                .get()
            var newWebtoon = doc.getElementsByClass("thumb7")
            var newWebtoon2 =doc.getElementsByClass("author2")
            var newWebtoon3 =doc.select("#content p")
            newWebtoonImg1=newWebtoon[0].getElementsByTag("img")[0].absUrl("src")
            newWebtoonTitle1=newWebtoon[0].getElementsByTag("img")[0].attr("title").trim()
            newWebtoonImg2=newWebtoon[1].getElementsByTag("img")[0].absUrl("src")
            newWebtoonTitle2=newWebtoon[1].getElementsByTag("img")[0].attr("title").trim()
            newWebtoonImg3=newWebtoon[2].getElementsByTag("img")[0].absUrl("src")
            newWebtoonTitle3=newWebtoon[2].getElementsByTag("img")[0].attr("title").trim()

            newWebtoonWriter1 =newWebtoon2[0].getElementsByTag("a")[0].attr("title").trim()
            newWebtoonWriter2 =newWebtoon2[1].getElementsByTag("a")[0].attr("title").trim()
            newWebtoonWriter3 =newWebtoon2[2].getElementsByTag("a")[0].attr("title").trim()

            newWebtoonCon1=newWebtoon3[1].text()
            newWebtoonCon2=newWebtoon3[3].text()
            newWebtoonCon3=newWebtoon3[5].text()

        }
    }
    inner class PagerAdapter : FragmentStateAdapter {
        //생성자
        constructor(activity: FragmentActivity):super(activity)
        //아이템이 몇개있냐
        override fun getItemCount()=3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->{
                    Fragment_RecWebtoon()
                }
                1->{
                    Fragment_NewWebtoon()
                }
                2->{
                    Fragment_GenreWebtoon()
                }
                else->{
                    Fragment_NewWebtoon()
                }
            }
        }
    }
}


