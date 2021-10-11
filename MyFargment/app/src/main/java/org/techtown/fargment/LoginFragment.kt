package org.techtown.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_menu.view.*


class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //프레그먼트 안에 버튼을 참조하는 방법
        val rootView=inflater.inflate(R.layout.fragment_login, container, false)
/*
프레그먼트안에서 메뉴프레그먼트띄우는게 아님
액티비티안에있는 온프레그먼트체인지를 호출해서 메뉴프레그먼트를 띄우겠다.
액티비티는뭐냐 프레그먼트 안에  액티비티라고하는 속성으로 들어있다 프레그먼트가 메인액티비티 올라오면 그 액티비티를
참조할수있다.
 */
        rootView.nextButton.setOnClickListener {
            val mainActivity=activity as MainActivity
            mainActivity.onFragmentChanged(1)
        }
        return rootView
    }
}
