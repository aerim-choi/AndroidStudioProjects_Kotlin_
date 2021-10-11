package org.techtown.naverwebtonjsoup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_new_webtoon.*
import org.jsoup.Jsoup

import org.techtown.naverwebtonjsoup.databinding.FragmentNewWebtoonBinding
import kotlin.concurrent.thread

class Fragment_NewWebtoon : Fragment() {
    //private var mBinding:FragmentNewWebtoonBinding?=null
    //private val binding get()=mBinding!!
    override fun onViewCreated(
        view:View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun showToast(message:String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //mBinding = FragmentNewWebtoonBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_webtoon, container, false)
    }
}