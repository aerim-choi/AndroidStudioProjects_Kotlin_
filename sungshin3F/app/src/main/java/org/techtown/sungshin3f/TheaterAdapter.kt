package org.techtown.sungshin3f

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.outfun1_item.view.*

class TheaterAdapter :RecyclerView.Adapter<TheaterAdapter.ViewHolder>(){
    val items=ArrayList<Theater>()

    lateinit var listener:OnTheaterItemClickListener

    override fun getItemCount()=items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheaterAdapter.ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.outfun1_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TheaterAdapter.ViewHolder, position: Int){
        val item=items[position]
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
        fun setItem(item:Theater){
            itemView.outfun1Title.text =item.title
            itemView.outfun1Exp.text= item.exp
            itemView.outfun1Image.setImageResource(item.iconDrawable)
        }
    }
}
