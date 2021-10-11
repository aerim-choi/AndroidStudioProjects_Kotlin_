package org.techtown.kotlinstudy09

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    onFragmentSelected(0)
                    bottomNavigationView.selectedItemId = R.id.tap1

                }
                R.id.item2 -> {
                    onFragmentSelected(2)
                    bottomNavigationView.selectedItemId = R.id.tap2
                }
                R.id.item3 -> {
                    onFragmentSelected(3)
                    bottomNavigationView.selectedItemId = R.id.tap3
                }
                R.id.item4 ->{
                    onFragmentSelected(4)
                    bottomNavigationView.selectedItemId =R.id.tab4

                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.tap1 ->{
                    onFragmentSelected(0)
                    navigationView.setCheckedItem(R.id.item1)
                }
                R.id.tap2 ->{
                    onFragmentSelected(2)
                    navigationView.setCheckedItem(R.id.item2)
                }
                R.id.tap3 ->{
                    onFragmentSelected(3)
                    navigationView.setCheckedItem(R.id.item3)
                }
                R.id.tab4->{
                    onFragmentSelected(4)
                    navigationView.setCheckedItem(R.id.item4)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }

    }
    fun onFragmentSelected(index:Int){
        //Fragment1()로 초기화 해줌
        var fragment: Fragment =MovieListFragment()

        when(index){
            0 -> {
                toolbar.title="영화목록"
                fragment=MovieListFragment()
            }
            1 ->{
                toolbar.title="영화상세"
                fragment=MovieDetailFragment()
            }
            2 ->{
                toolbar.title="예매순"
                fragment=Fragment2()
            }
            3 ->{
                toolbar.title="영화관"
                fragment=Fragment3()
            }
            4->{
                toolbar.title="즐겨찾기"
                fragment=Fragment4()
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

