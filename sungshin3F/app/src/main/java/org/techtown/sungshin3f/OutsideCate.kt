package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_outsidecate.*


class OutsideCate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outsidecate)


        InsideCate1Fbtn.setOnClickListener{
            val outFun1Intent= Intent(this,OutFun1::class.java)
            startActivity(outFun1Intent)
        }
        InsideCate2Fbtn.setOnClickListener {
            //일단민영이가 한걸로 연결함
            val outFood1Intent= Intent(this,OutFood2::class.java)
            startActivity(outFood1Intent)
        }
        InsideCate3Fbtn.setOnClickListener{

        }



        //토글 만드는방법(개발자가 이렇게 쓰라고 한거임 )
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    val outsideIntent= Intent(this,OutFun1::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item2 -> {
                    val outsideIntent= Intent(this,OutFood2::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item3 -> {
                    val outsideIntent= Intent(this,OutFashion1::class.java)
                    startActivity(outsideIntent)
                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }
    }


    override fun onBackPressed() {
        //메뉴바열렸을때 뒤로가기 누르면 메뉴바 닫힌다.
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{//메뉴바 닫혔을때 뒤로가기누르면 화면이 뒤로간다.
            finish()
            super.onBackPressed()
        }
    }

}