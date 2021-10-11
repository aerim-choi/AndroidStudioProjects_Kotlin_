package org.techtown.drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //토글 만드는방법(개발자가 이렇게 쓰라고 한거임 )
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    onFragmentSelected(0)
                }
                R.id.item2 -> {
                    onFragmentSelected(1)
                }
                R.id.item3 -> {
                    onFragmentSelected(2)
                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }
    }
    fun onFragmentSelected(index:Int){
        //Fragment1()로 초기화 해줌
        var fragment: Fragment=Fragment1()

        when(index){
            0 -> {
                toolbar.title="첫번째 화면"
                fragment=Fragment1()
            }
            1 ->{
                toolbar.title="두번째 화면"
                fragment=Fragment2()
            }
            2 ->{
                toolbar.title="세번째 화면"
                fragment=Fragment3()
            }
        }
        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container,fragment)
        }.commit()


    }

    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}

