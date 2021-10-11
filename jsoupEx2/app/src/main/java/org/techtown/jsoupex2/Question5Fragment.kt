package org.techtown.jsoupex2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.jsoupex2.databinding.FragmentQuestion1Binding
import org.techtown.jsoupex2.databinding.FragmentQuestion5Binding

class Question5Fragment : Fragment() {
    private var mBinding: FragmentQuestion5Binding?=null
    private val binding get()=mBinding!!
    companion object{
        var question5:Boolean?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentQuestion5Binding.inflate(inflater,container,false)
        binding.question5yesbtn.setOnClickListener {
            NewRecMainActivity.checkbool[4]=true
            binding.question5nobtn.setBackgroundColor(Color.WHITE)
            question5=true
            binding.question5yesbtn.setBackgroundColor(Color.GRAY)
        }
        binding.question5nobtn.setOnClickListener {
            NewRecMainActivity.checkbool[4]=true
            binding.question5yesbtn.setBackgroundColor(Color.WHITE)
            question5=false
            binding.question5nobtn.setBackgroundColor(Color.GRAY)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onDestroyView(){
        mBinding=null
        super.onDestroyView()
    }
}