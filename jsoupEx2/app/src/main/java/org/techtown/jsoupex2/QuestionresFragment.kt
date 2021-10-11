package org.techtown.jsoupex2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.techtown.jsoupex2.databinding.FragmentQuestion1Binding
import org.techtown.jsoupex2.databinding.FragmentQuestionresBinding


class QuestionresFragment : Fragment() {
    private var mBinding: FragmentQuestionresBinding?=null
    private val binding get()=mBinding!!

    private var checkres:Int=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        mBinding= FragmentQuestionresBinding.inflate(inflater,container,false)

        binding.resentrancebtn.setOnClickListener {
            checkres=0//초기화
            for(i in 0..4) {
                when (NewRecMainActivity.checkbool[i]) {
                    true->
                        checkres=checkres+1
                }
            }
            when(checkres){
                5->{
                    var intent=Intent(getActivity(),Recwebtoonres::class.java)
                    startActivity(intent)
                }
                else->{
                    for (i in 0..4){
                        when(NewRecMainActivity.checkbool[i]){
                            false ->{
                                showToast("${i + 1}번째 질문에 대답해 주세요.")
                                showToast(checkres.toString())
                            }
                        }
                    }
                }
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onDestroyView(){
        mBinding=null
        super.onDestroyView()
    }
    fun showToast(message:String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}