package org.techtown.jsoupex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import org.techtown.jsoupex2.databinding.ActivityRecwebtoonresBinding
import java.util.*

class Recwebtoonres : AppCompatActivity() {
    private var mBinding: ActivityRecwebtoonresBinding?=null
    private val binding get()=mBinding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding =  ActivityRecwebtoonresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //작품 15개 초기화
        var webtoon1=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/570503/thumbnail/thumbnail_IMAG10_023d23be-91f9-46c5-a1ff-152d6238e892.jpg","연애혁명","https://comic.naver.com/webtoon/list?titleId=570503")
        var webtoon2=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/654774/thumbnail/thumbnail_IMAG10_c966c4af-f642-4531-b39b-74c284034d9e.jpg", "소녀의세계", "https://comic.naver.com/webtoon/list?titleId=654774")
        var webtoon3=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/746834/thumbnail/thumbnail_IMAG10_ef161cee-2248-446e-99e7-f6bcd8ded7b5.jpg", "청춘블라썸", "https://comic.naver.com/webtoon/list?titleId=746834")
        var webtoon4=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/654138/thumbnail/thumbnail_IMAG10_6703cec5-78ee-4a87-9362-e46b6763b432.jpg", "은주의방", "https://comic.naver.com/webtoon/list?titleId=654138")
        var webtoon5=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/736277/thumbnail/thumbnail_IMAG10_3ff8475e-6085-4188-a359-920a8801b419.jpg","싸움독학","https://comic.naver.com/webtoon/list?titleId=736277")
        var webtoon6=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/721948/thumbnail/thumbnail_IMAG10_72bdf971-8699-4e5e-aea9-e22569ad9437.jpg", "스터디그룹", "https://comic.naver.com/webtoon/list?titleId=721948")
        var webtoon7=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/773797/thumbnail/thumbnail_IMAG10_47682705-9b27-4d0e-a8dc-33f57dfe8667.jpg", "나혼자만레벨업", "https://comic.naver.com/webtoon/list?titleId=773797")
        var webtoon8=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/183559/thumbnail/thumbnail_IMAG10_9a752bec-9ebd-4214-9449-28cf4defc650.jpg", "신의탑", "https://comic.naver.com/webtoon/list?titleId=183559")
        var webtoon9=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/729767/thumbnail/thumbnail_IMAG10_e9afa12f-a8a7-456e-a9e3-cf4c3ac09a4c.jpg", "고래별", "https://comic.naver.com/webtoon/list?titleId=729767")
        var webtoon10=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/701081/thumbnail/thumbnail_IMAG10_7120be5e-b5c7-4727-aba5-cb500c6098ab.jpg","스위트홈","https://comic.naver.com/webtoon/list?titleId=701081")
        var webtoon11=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/557672/thumbnail/thumbnail_IMAG10_d05c81ab-ea19-473b-818f-3aceb657ae1e.jpg", "기기괴괴", "https://comic.naver.com/webtoon/list?titleId=557672")
        var webtoon12=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/708378/thumbnail/thumbnail_IMAG10_e63ecfd1-9f7d-4b65-a1df-05f6241daba0.jpg", "타인은지옥이다", "https://comic.naver.com/webtoon/list?titleId=708378")
        var webtoon13=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/758037/thumbnail/thumbnail_IMAG10_a2297504-4912-4c7e-a5a8-524d6fc77103.jpg", "참교육", "https://comic.naver.com/webtoon/list?titleId=758037")
        var webtoon14=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/736989/thumbnail/thumbnail_IMAG10_dc639e95-a787-49bd-9bb6-b835909a764d.jpg","더복서","https://comic.naver.com/webtoon/list?titleId=736989")
        var webtoon15=Webtoon("https://shared-comic.pstatic.net/thumb/webtoon/774862/thumbnail/thumbnail_IMAG10_a192356d-8ef5-4e95-94eb-4f71b4ad09e9.jpg", "조조코믹스", "https://comic.naver.com/webtoon/list?titleId=774862")

        //추천작1

        if (Question1Fragment.question1 == true && Question5Fragment.question5==true) {
            var random1= Random()
            var randomnum1=random1.nextInt(3)
            when(randomnum1){
                0->{
                    Glide.with(this).load(webtoon1.imgurl).into(binding.recwebtoon1img)
                    binding.recwebtoon1title.text=webtoon1.title
                }
                1->{
                    Glide.with(this).load(webtoon2.imgurl).into(binding.recwebtoon1img)
                    binding.recwebtoon1title.text=webtoon2.title
                }
                2->{
                    Glide.with(this).load(webtoon3.imgurl).into(binding.recwebtoon1img)
                    binding.recwebtoon1title.text=webtoon3.title
                }
            }

        }else if(Question1Fragment.question1 == true&& Question5Fragment.question5==false){
            Glide.with(this).load(webtoon4.imgurl).into(binding.recwebtoon1img)
            binding.recwebtoon1title.text=webtoon4.title
        }else if(Question1Fragment.question1 == false&& Question5Fragment.question5==true){
            var random2= Random()
            var randomnum2=random2.nextInt(2)
            when(randomnum2){
                0->{
                    Glide.with(this).load(webtoon5.imgurl).into(binding.recwebtoon1img)
                    binding.recwebtoon1title.text=webtoon5.title
                }
                1->{
                    Glide.with(this).load(webtoon6.imgurl).into(binding.recwebtoon1img)
                    binding.recwebtoon1title.text=webtoon6.title
                }
            }
        }else{
            Glide.with(this).load(webtoon7.imgurl).into(binding.recwebtoon1img)
            binding.recwebtoon1title.text=webtoon7.title
        }
        //추천작2
        if(Question4Fragment.question4==true){
            Glide.with(this).load(webtoon8.imgurl).into(binding.recwebtoon2img)
            binding.recwebtoon2title.text=webtoon8.title
        }else{
            Glide.with(this).load(webtoon9.imgurl).into(binding.recwebtoon2img)
            binding.recwebtoon2title.text=webtoon9.title
        }
        //추천작3
        if (Question2Fragment.question2 == true && Question3Fragment.question3==true) {
            Glide.with(this).load(webtoon10.imgurl).into(binding.recwebtoon3img)
            binding.recwebtoon3title.text=webtoon10.title
        }else if(Question2Fragment.question2 == true&& Question3Fragment.question3==false){
            var random3= Random()
            var randomnum3=random3.nextInt(2)
            when(randomnum3){
                0->{
                    Glide.with(this).load(webtoon11.imgurl).into(binding.recwebtoon3img)
                    binding.recwebtoon3title.text=webtoon11.title
                }
                1->{
                    Glide.with(this).load(webtoon12.imgurl).into(binding.recwebtoon3img)
                    binding.recwebtoon3title.text=webtoon12.title
                }
            }
        }else if(Question2Fragment.question2== false&& Question3Fragment.question3==true){
            var random4= Random()
            var randomnum4=random4.nextInt(2)
            when(randomnum4){
                0->{
                    Glide.with(this).load(webtoon13.imgurl).into(binding.recwebtoon3img)
                    binding.recwebtoon3title.text=webtoon13.title
                }
                1->{
                    Glide.with(this).load(webtoon14.imgurl).into(binding.recwebtoon3img)
                    binding.recwebtoon3title.text=webtoon14.title
                }
            }
        }else{
            Glide.with(this).load(webtoon15.imgurl).into(binding.recwebtoon3img)
            binding.recwebtoon3title.text=webtoon15.title
        }

    }
}