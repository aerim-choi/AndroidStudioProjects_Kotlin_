package org.techtown.jsoupex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import org.jsoup.Jsoup
import org.techtown.jsoupex2.databinding.ActivityActionwebtoonBinding
import org.techtown.jsoupex2.databinding.ActivityThrillerwebtoonBinding
import kotlin.concurrent.thread

class Thrillerwebtoon : AppCompatActivity() {
    private var mBinding: ActivityThrillerwebtoonBinding?=null
    private val binding get()=mBinding!!
    val GenWebtoonImgs=ArrayList<String>()
    val GenWebtoonTitles=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityThrillerwebtoonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        GenreWebtoonThrInfo()
    }
    private fun GenreWebtoonThrInfo(){
        thread {
            val doc = Jsoup.connect("https://comic.naver.com/webtoon/genre?genre=thrill")
                .get()
            val GenWebtoon = doc.getElementsByClass("thumb")


            for (i in 1..12) {
                GenWebtoonImgs.add(GenWebtoon[i].getElementsByTag("img")[0].absUrl("src"))
                GenWebtoonTitles.add(GenWebtoon[i].getElementsByTag("img")[0].attr("title").trim())
            }
            this.runOnUiThread{

                Glide.with(this).load(GenWebtoonImgs[0]).into(binding.rank1img)
                binding.rank1title.text =GenWebtoonTitles[0]

                Glide.with(this).load(GenWebtoonImgs[1]).into(binding.rank2img)
                binding.rank2title.text =GenWebtoonTitles[1]

                Glide.with(this).load(GenWebtoonImgs[2]).into(binding.rank3img)
                binding.rank3title.text =GenWebtoonTitles[2]

                Glide.with(this).load(GenWebtoonImgs[3]).into(binding.rank4img)
                binding.rank4title.text =GenWebtoonTitles[3]

                Glide.with(this).load(GenWebtoonImgs[4]).into(binding.rank5img)
                binding.rank5title.text =GenWebtoonTitles[4]

                Glide.with(this).load(GenWebtoonImgs[5]).into(binding.rank6img)
                binding.rank6title.text =GenWebtoonTitles[5]

                Glide.with(this).load(GenWebtoonImgs[6]).into(binding.rank7img)
                binding.rank7title.text =GenWebtoonTitles[6]

                Glide.with(this).load(GenWebtoonImgs[7]).into(binding.rank8img)
                binding.rank8title.text =GenWebtoonTitles[7]

                Glide.with(this).load(GenWebtoonImgs[8]).into(binding.rank9img)
                binding.rank9title.text =GenWebtoonTitles[8]

                Glide.with(this).load(GenWebtoonImgs[9]).into(binding.rank10img)
                binding.rank10title.text =GenWebtoonTitles[9]

                Glide.with(this).load(GenWebtoonImgs[10]).into(binding.rank11img)
                binding.rank11title.text =GenWebtoonTitles[10]

                Glide.with(this).load(GenWebtoonImgs[11]).into(binding.rank12img)
                binding.rank12title.text =GenWebtoonTitles[11]
            }

        }
    }
}