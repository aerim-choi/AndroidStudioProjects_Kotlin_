package org.techtown.sungshin3f

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.outfood2_profile.view.*

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //레이아웃 안의 텍스트뷰에 글자를 설정할 수 있도록 만든 메서드 :: 이름, 위치 등 설정
        fun setItem(item: outfood2_profile) {
            itemView.outFoodName.text = item.name
            itemView.outFoodLocation.text = item.locate
            itemView.outFoodTime.text = item.time
            itemView.outFoodStar.text = item.star
            itemView.outFoodHeart.text = item.heart
        }

        //listener 객체에서 클릭 이벤트 처리 가능.
        init {
            itemView.setOnClickListener {
                listener?.onItemClick(this, itemView, adapterPosition)
            }
        }
    }

    //아이템 데이터 각각 : 객체에 저장
    var items = ArrayList<outfood2_profile>()

    override fun getItemCount()= items.size

    //xml 레이아웃을 인플레이션하여 파라미터로 전달되는 뷰 그룹 객체에 설정함.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.outfood2_profile, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    //인터페이스 구현 객체
    lateinit var listener: OnPersonItemClickListener
}

interface OnPersonItemClickListener {
    //뷰홀더 객체, 뷰 객체, 포지션 정보(몇 번째 아이템인지 구분할 수 있는 인덱스 값) 전달되도록.
    fun onItemClick(holder:PersonAdapter.ViewHolder?, view: View?, position:Int)
}