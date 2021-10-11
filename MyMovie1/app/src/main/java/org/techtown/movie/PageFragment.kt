package org.techtown.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_page.view.*

class PageFragment : Fragment() {

    var imageId=0
    var title:String?=null
    var details1:String?=null
    var details2:String?=null

    companion object{

        fun newInstance(imageId:Int, title:String?, details1:String?,details2:String?):PageFragment{
            val fragment = PageFragment()

            //액티비티 위에올라가야 초기화가되는거임
            //그때 사용할 임시데이터로 argument를 넣어준것이다.

            val bundle =Bundle()
            bundle.putInt("imageId",imageId)
            bundle.putString("title",title)
            bundle.putString("details1",details1)
            bundle.putString("details2",details2)
            fragment.arguments=bundle

            return fragment
        }

    }
    //실제 프레그먼트가 액티비티위에올라가 초기화 될 시점에 onCreate가 호출될것이다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //같은뜻 if(arguments != null){ }
        //this가 이제 arguments다.
        //임시로 넣어놨던것을 할당해주었다.
        arguments?.apply{
            imageId=getInt("imageId")
            title=getString("title")
            details1=getString("details1")
            details2=getString("details2")
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_page, container, false)

        //레이아웃 값에 집어넣기
        rootView.posterImageView.setImageResource(imageId)
        rootView.titleTextView.text=title
        rootView.details1TextView.text=details1
        rootView.details2TextView.text=details2

        return rootView
    }

}