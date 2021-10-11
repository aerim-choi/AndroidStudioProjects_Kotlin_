package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_outfun1.*


class OutFun1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outfun1)
        //pager구현
        pager.adapter= PagerAdapter(this)
        pager.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        pager.offscreenPageLimit=5

        indicator.setViewPager(pager)
        indicator.createIndicators(5,0)

        pager.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position:Int){
                super.onPageSelected(position)
                showToast("페이지 선택: ${position}")
                indicator.animatePageSelected(position)
            }
        })


        //recyclerview구현
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        outfun1recyclerView.layoutManager=layoutManager

        val adapter = TheaterAdapter()

        adapter.items.add(Theater(R.drawable.play1,"일리아드","2021.06.29-2021.09.05"))
        adapter.items.add(Theater(R.drawable.play2,"완벽한타인","2021.05.18-2021.08.01"))
        adapter.items.add(Theater(R.drawable.play3,"렁스","2021.06.26-2021.09.05"))
        adapter.items.add(Theater(R.drawable.play4,"옥탑방고양이","2010.04.06-2021.08.31"))
        adapter.items.add(Theater(R.drawable.play5,"쉬어매드니스","2015.11.12-2021.08.22"))

        outfun1recyclerView.adapter=adapter

        adapter.listener=object:OnTheaterItemClickListener{
            override fun onItemClick(
                holder: TheaterAdapter.ViewHolder?,
                view: View?,
                position: Int
            ) {
                showToast("아이템클릭됨: ${position}")
            }
        }

        //토글 만드는방법(개발자가 이렇게 쓰라고 한거임 )
        setSupportActionBar(toolbar)

        val toggle =
            ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    finish()
                    val outsideIntent = Intent(this, OutFun1::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item2 -> {
                    finish()
                    val outsideIntent = Intent(this, OutFood1::class.java)
                    startActivity(outsideIntent)
                }
                R.id.item3 -> {
                    finish()
                    val outsideIntent = Intent(this, OutFashion1::class.java)
                    startActivity(outsideIntent)
                }
            }
            //바로가기 메뉴 닫기
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }

    }
    inner class PagerAdapter : FragmentStateAdapter {
        //생성자
        constructor(activity: FragmentActivity):super(activity)
        //아이템이 몇개있냐
        override fun getItemCount()=5

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->{
                    Fragment1()
                }
                1->{
                    Fragment2()
                }
                2->{
                    Fragment3()
                }
                3->{
                    Fragment4()
                }
                4->{
                    Fragment5()
                }
                5->{
                    Fragment6()
                }
                else->{
                    Fragment1()
                }
            }
        }
    }
    fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }




}