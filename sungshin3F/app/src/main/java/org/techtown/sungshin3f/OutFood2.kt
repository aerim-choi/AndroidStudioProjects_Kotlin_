package org.techtown.sungshin3f

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_outfood2.*



class OutFood2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outfood2)
//
//        //토글 만드는방법(개발자가 이렇게 쓰라고 한거임 )
//        setSupportActionBar(toolbar)
//
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        navigationView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.item1 -> {
//                    val outsideIntent= Intent(this,OutFun1::class.java)
//                    startActivity(outsideIntent)
//                }
//                R.id.item2 -> {
//                    val outsideIntent= Intent(this,OutFood2::class.java)
//                    startActivity(outsideIntent)
//                }
//                R.id.item3 -> {
//                    val outsideIntent= Intent(this,OutFashion1::class.java)
//                    startActivity(outsideIntent)
//                }
//            }
//            //바로가기 메뉴 닫기
//            drawerLayout.closeDrawer(GravityCompat.START)
//
//            return@setNavigationItemSelectedListener true
//        }
//
//


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager=layoutManager
        val adapter=PersonAdapter()

        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "5.0", "5.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "4.0", "4.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "3.0", "3.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "2.0", "2.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "1.0", "1.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "4.0", "5.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "3.0", "4.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "2.0", "3.0"))
        adapter.items.add(outfood2_profile("성신여대", "서울특별시 성북구 돈암동 보문로34다길 2", "9AM to 10 PM", "1.0", "2.0"))

        recyclerView.adapter=adapter

        //클릭 이벤트. 아이템은 items 속성에 arrayList 자료형으로 들어있으므로 item[position]으로 참조함.
        adapter.listener = object : OnPersonItemClickListener{
            override fun onItemClick(
                holder: PersonAdapter.ViewHolder?,
                view: View?,
                position: Int
            ) {
                val name = adapter.items[position]
                showToast("아이템 선택됨 : $name")
            }
        }
    }

    //    fun onFragmentSelected(index:Int){
//        //Fragment1()로 초기화 해줌
//        var fragment: Fragment = Fragment1()
//
//        when(index){
//            0 -> {
//                toolbar.title="내부:첫번째 화면"
//                fragment= Fragment4()
//            }
//            1 ->{
//                toolbar.title="내부:두번째 화면"
//                fragment= Fragment5()
//            }
//            2 ->{
//                toolbar.title="내부:세번째 화면"
//                fragment= Fragment6()
//            }
//        }
//        with(supportFragmentManager.beginTransaction()){
//            replace(R.id.container,fragment)
//        }.commit()
//
//
//    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{

            super.onBackPressed()
        }
    }

    fun showToast(meassage:String){
        Toast.makeText(applicationContext, meassage, Toast.LENGTH_LONG).show()
    }

    //리사이클러뷰
}