package org.techtown.sunshine3fweatherapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.lang.reflect.Array.getInt
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val CITY: String = "Seoul,KR"
    val API: String = "403fa3d2d23dc07ae8333c4f51273965" // Use API key

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTask().execute()
        setSupportActionBar(toolbar)

        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                }
                R.id.item2 -> {
                }
                R.id.item3 -> {
                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }
    }
    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API").readText(
                    Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            /* Extracting JSON returns from the API */
            val jsonObj = JSONObject(result)
            val main = jsonObj.getJSONObject("main")
            val sys = jsonObj.getJSONObject("sys")

            val weather = jsonObj.getJSONArray("weather").getJSONObject(0)

            //API에서 온도 받아오기, 온도 INT형으로 변환
            var temp = main.getString("temp")
            var tempInt=convertTemp(temp)

            var tempfeel=main.getString("feels_like")
            var tempfeelInt=convertTemp(tempfeel)

            var tempMin = main.getString("temp_min")
            var tempMinInt=convertTemp(tempMin)

            var tempMax =  main.getString("temp_max")
            var tempMaxInt=convertTemp(tempMax)

            val humidity = main.getString("humidity")+"%"

            var id =weather.getInt("id")
            var weatherDescription = weather.getString("description")

            //옷차림
            when(tempfeelInt){
                in 28..50->{
                    clothes1.setImageResource(R.drawable._01_clothes)
                    clothes2.setImageResource(R.drawable._02_clothes)
                    clothes3.setImageResource(R.drawable._38_clothes)
                    clothes4.setImageResource(R.drawable._29_clothes)
                    clothesrec.text="민소매,반팔,반바지,원피스"
                }
                in 23..27->{
                    clothes1.setImageResource(R.drawable._21_clothes)
                    clothes2.setImageResource(R.drawable._09_clothes)
                    clothes3.setImageResource(R.drawable._06_clothes)
                    clothes4.setImageResource(R.drawable._44_clothes)
                    clothesrec.text="반팔,얇은셔츠,반바지,면바지"
               }
                in 20..22->{
                    clothes1.setImageResource(R.drawable._39_clothes)
                    clothes2.setImageResource(R.drawable._37_clothes)
                    clothes3.setImageResource(R.drawable._04_clothes)
                    clothes4.setImageResource(R.drawable._41_clothes)
                    clothesrec.text="얇은 가디건,긴팔,면바지,청바지"
                }
                in 19..17->{
                    clothes1.setImageResource(R.drawable._12_clothes)
                    clothes2.setImageResource(R.drawable._39_clothes)
                    clothes3.setImageResource(R.drawable._04_clothes)
                    clothes4.setImageResource(R.drawable._41_clothes)
                    clothesrec.text="얇은 니트,맨투맨,가디건,청바지"
                }in 16..12->{
                    clothes1.setImageResource(R.drawable._05_casual)
                    clothes2.setImageResource(R.drawable._34_clothes)
                    clothes3.setImageResource(R.drawable._04_clothes)
                    clothes4.setImageResource(R.drawable._41_clothes)
                    clothesrec.text="자켓,가디건,야상,스타킹,청바지,면바지"
                }in 11..9->{
                    clothes1.setImageResource(R.drawable._05_casual)
                    clothes2.setImageResource(R.drawable._27_clothes)
                    clothes3.setImageResource(R.drawable._04_clothes)
                    clothes4.setImageResource(R.drawable._41_clothes)
                    clothesrec.text="자켓,트렌치코트,야상,니트,청바지,스타킹"
                }in 8..5-> {
                    clothes1.setImageResource(R.drawable._05_casual)
                    clothes2.setImageResource(R.drawable._39_clothes)
                    clothes3.setImageResource(R.drawable._34_clothes)
                    clothes4.setImageResource(R.drawable._41_clothes)
                    clothesrec.text="코트,가죽자켓,히트텍,니트,레깅스"
                }
                else->{//4도미만
                    clothes1.setImageResource(R.drawable._43_bad_weather)
                    clothes2.setImageResource(R.drawable._14_clothes)
                    clothes3.setImageResource(R.drawable._04_clothes)
                    clothes4.setImageResource(R.drawable._26_accesories)
                    clothesrec.text="패딩,두꺼운코트,목도리,기모제품"
                }
            }


            //날씨 그림
            when(id) {
               800->{
                    weatherDescription = "맑음"
                    weatherImage.setImageResource(R.drawable._1d)
                    umbrella.text=" "
                }
                801->{
                    weatherDescription = "구름 조금"
                    weatherImage.setImageResource(R.drawable._2d)
                    umbrella.text=" "
                }
                802->{
                    weatherDescription = "흐림"
                    weatherImage.setImageResource(R.drawable._3d)
                    umbrella.text=" "
                }
                803->{
                    weatherDescription = "흩어진 구름"
                    weatherImage.setImageResource(R.drawable._4d)
                    umbrella.text=" "
                }
                521,531->{
                    weatherDescription = "소나기"
                    weatherImage.setImageResource(R.drawable._9d)
                    umbrella.text="오늘은 비가 와요. 우산을 꼭 챙기세요!"
                }
                in 500..520->{
                    weatherDescription = "비"
                    weatherImage.setImageResource(R.drawable._10d)
                    umbrella.text="오늘은 비가와요. 우산을 꼭 챙기세요!"
                }
                522->{
                    weatherDescription = "강한 소나기"
                    weatherImage.setImageResource(R.drawable._10d)
                    umbrella.text="오늘은 비가와요. 우산을 꼭 챙기세요!"
                }
                in 200..232->{
                    weatherDescription = "천둥"
                    weatherImage.setImageResource(R.drawable._11d)
                    umbrella.text=" "
                }
                in 600..622->{
                    weatherDescription = "눈"
                    weatherImage.setImageResource(R.drawable._13d)
                    umbrella.text="오늘은 눈이와요. 우산을 꼭 챙기세요!"
                }
                in 700..781->{
                    weatherDescription = "안개"
                    weatherImage.setImageResource(R.drawable._50d)
                    umbrella.text=" "
                }
            }




            /* Populating extracted data into our views */
            findViewById<TextView>(R.id.status).text = weatherDescription.capitalize()
            findViewById<TextView>(R.id.temp).text = tempInt.toString()+"°C"
            findViewById<TextView>(R.id.recommend).text = "체감온도 ${tempfeelInt.toString()}°C 일때, 이런 옷 추천드려요!"
            findViewById<TextView>(R.id.temp_min).text = tempMinInt.toString()+"°C"
            findViewById<TextView>(R.id.temp_max).text = tempMaxInt.toString()+"°C"
            findViewById<TextView>(R.id.tempfeel).text = tempfeelInt.toString()+"°C"
            findViewById<TextView>(R.id.humidity).text = humidity.toString()



        }
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    private fun convertTemp(arg:String): Int {
        var covertvalue=arg.split(".")
        return covertvalue[0].toInt()
    }

}