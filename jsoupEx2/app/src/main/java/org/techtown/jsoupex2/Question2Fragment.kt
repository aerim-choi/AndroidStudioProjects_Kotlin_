package org.techtown.jsoupex2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.jsoupex2.databinding.FragmentQuestion1Binding
import org.techtown.jsoupex2.databinding.FragmentQuestion2Binding


class Question2Fragment : Fragment() {
    private var mBinding: FragmentQuestion2Binding?=null
    private val binding get()=mBinding!!
    companion object{
        var question2:Boolean?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentQuestion2Binding.inflate(inflater,container,false)
        binding.question2yesbtn.setOnClickListener{
            NewRecMainActivity.checkbool[1]=true
            binding.question2nobtn.setBackgroundColor(Color.WHITE)
            question2=true
            binding.question2yesbtn.setBackgroundColor(Color.GRAY)
        }
        binding.question2nobtn.setOnClickListener {
            NewRecMainActivity.checkbool[1]=true
            binding.question2yesbtn.setBackgroundColor(Color.WHITE)
            question2=false
            binding.question2nobtn.setBackgroundColor(Color.GRAY)
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onDestroyView(){
        mBinding=null
        super.onDestroyView()
    }

}