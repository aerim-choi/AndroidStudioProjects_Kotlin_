package org.techtown.sungshin3f
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_outsidecate.*
import org.techtown.sungshin3f.R
//Fragment파일 예시파일이랍니다. 잘작동이되는지 안되는지 넣어볼때,,그러니 나중에 지울테니 걱정 안해도된답니다!!!

class Fragment1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)
    }



}