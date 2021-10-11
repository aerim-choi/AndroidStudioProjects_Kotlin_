package org.techtown.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager

        val adapter = PersonAdapter()

        adapter.items.add(Person("홍길동1","010-1000-1000"))
        adapter.items.add(Person("홍길동2","010-2000-1000"))
        adapter.items.add(Person("홍길동3","010-3000-1000"))
        adapter.items.add(Person("홍길동3","010-4000-1000"))
        adapter.items.add(Person("홍길동4","010-5000-1000"))
        adapter.items.add(Person("홍길동5","010-6000-1000"))
        adapter.items.add(Person("홍길동6","010-7000-1000"))

        recyclerView.adapter = adapter


        adapter.listener=object:OnPersonItemClickListener{
            override fun onItemClick(
                holder: PersonAdapter.ViewHolder?,
                view: View?,
                position: Int
            ) {
                showToast("아이템클릭됨: ${position}")
            }
        }


    }
    fun showToast(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}