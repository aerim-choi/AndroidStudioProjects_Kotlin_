package org.techtown.jsopex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import org.jsoup.Jsoup
import org.techtown.jsopex.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private var mBinding:ActivityMainBinding?=null
    private val binding get()=mBinding!!
    val TAG:String = "MainActivity : "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        NewWebtoonInfo()
    }
    private fun NewWebtoonInfo(){
        thread{
            val doc= Jsoup.connect("https://comic.naver.com/webtoon/weekday")
                .get()
            val newWebtoon = doc.getElementsByClass("thumb7")
            val newWebtoon2 =doc.getElementsByClass("author2")
            val newWebtoon3 =doc.select("#content p")
            val newWebtoonImg1=newWebtoon[0].getElementsByTag("img")[0].absUrl("src")
            val newWebtoonTitle1=newWebtoon[0].getElementsByTag("img")[0].attr("title").trim()
            val newWebtoonImg2=newWebtoon[1].getElementsByTag("img")[0].absUrl("src")
            val newWebtoonTitle2=newWebtoon[1].getElementsByTag("img")[0].attr("title").trim()
            val newWebtoonImg3=newWebtoon[2].getElementsByTag("img")[0].absUrl("src")
            val newWebtoonTitle3=newWebtoon[2].getElementsByTag("img")[0].attr("title").trim()

            val newWebtoonWriter1 =newWebtoon2[0].getElementsByTag("a")[0].attr("title").trim()
            val newWebtoonWriter2 =newWebtoon2[1].getElementsByTag("a")[0].attr("title").trim()
            val newWebtoonWriter3 =newWebtoon2[2].getElementsByTag("a")[0].attr("title").trim()

            val newWebtoonCon1=newWebtoon3[1].text()
            val newWebtoonCon2=newWebtoon3[3].text()
            val newWebtoonCon3=newWebtoon3[5].text()



            this.runOnUiThread{
                Picasso.get().load(newWebtoonImg1).into(binding.NewWebtoonImg1)
                binding.NewWebtoonTit1.text =newWebtoonTitle1
                binding.NewWebtoonWriter1.text =newWebtoonWriter1
                binding.NewWebtoonCon1.text =newWebtoonCon1

                Picasso.get().load(newWebtoonImg2).into(binding.NewWebtoonImg2)
                binding.NewWebtoonTit2.text =newWebtoonTitle2
                binding.NewWebtoonWriter2.text =newWebtoonWriter2
                binding.NewWebtoonCon2.text =newWebtoonCon2

                Picasso.get().load(newWebtoonImg3).into(binding.NewWebtoonImg3)
                binding.NewWebtoonTit3.text =newWebtoonTitle3
                binding.NewWebtoonWriter3.text =newWebtoonWriter3
                binding.NewWebtoonCon3.text =newWebtoonCon3


            }
        }
    }
}