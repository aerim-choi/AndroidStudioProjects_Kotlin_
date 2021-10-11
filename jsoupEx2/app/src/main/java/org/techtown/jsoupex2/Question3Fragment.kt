package org.techtown.jsoupex2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.jsoupex2.databinding.FragmentQuestion1Binding
import org.techtown.jsoupex2.databinding.FragmentQuestion3Binding


class Question3Fragment : Fragment() {
    private var mBinding: FragmentQuestion3Binding?=null
    private val binding get()=mBinding!!

    companion object{
        var question3:Boolean?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentQuestion3Binding.inflate(inflater,container,false)
        binding.question3yesbtn.setOnClickListener {
            NewRecMainActivity.checkbool[2]=true
            binding.question3nobtn.setBackgroundColor(Color.WHITE)
            question3=true
            binding.question3yesbtn.setBackgroundColor(Color.GRAY)
        }
        binding.question3nobtn.setOnClickListener {
            NewRecMainActivity.checkbool[2]=true
            binding.question3yesbtn.setBackgroundColor(Color.WHITE)
            question3=false
            binding.question3nobtn.setBackgroundColor(Color.GRAY)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onDestroyView(){
        mBinding=null
        super.onDestroyView()
    }
}