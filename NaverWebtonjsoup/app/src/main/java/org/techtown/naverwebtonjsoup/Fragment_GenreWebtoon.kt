package org.techtown.naverwebtonjsoup



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_genre_webtoon.*
import org.techtown.naverwebtonjsoup.databinding.FragmentGenreWebtoonBinding



class Fragment_GenreWebtoon : Fragment() {


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        rommancebtn.setOnClickListener {
            showToast("로맨스")

        }
        actionbtn.setOnClickListener {
            showToast("ㅇㅅ")

        }
        thrillerbtn.setOnClickListener {
            showToast("ㅅㄹㄹ")

        }
        periodbtn.setOnClickListener {

            showToast("ㅅㄷㄱ")

        }
        fantasybtn.setOnClickListener {
            showToast("ㅍㅌㅈ")

        }



    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_genre_webtoon, container, false)
    }

    fun showToast(message:String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }





}