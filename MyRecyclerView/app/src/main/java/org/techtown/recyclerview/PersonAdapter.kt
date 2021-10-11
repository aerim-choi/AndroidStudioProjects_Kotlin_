package org.techtown.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person_item.view.*

class PersonAdapter :RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    val items = ArrayList<Person>()

    lateinit var listener:OnPersonItemClickListener

    //아이템 몇개를 갖고있니?
    override fun getItemCount() = items.size
    //일단 아이템이 생성되긴 해야하니까 그때 실행되는 거임
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //바로 보일거 아니니까 false임
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        return ViewHolder(itemView)
    }
    //viewHolder가 가지고있는 각각의 아이템위한 뷰객체가 있으면 데이터를 설정해주는 시점
    //몇번째 person객체를 보여줘야하는지를 넘겨주는것이 position임
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= items[position]
        holder.setItem(item)
    }


    //스크롤하면서 안보이는 부분을 밑으로 내려서 각각의 아이템을 재사용할수 있게 해주는게뷰홀더
    //내부클래스(클래스 안에 클래스)
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        init{
            itemView.setOnClickListener{
                listener?.onItemClick(this,itemView,adapterPosition)
            }
        }
        fun setItem(item:Person){
            itemView.output1.text =item.name
            itemView.output2.text= item.mobile
        }
    }


}