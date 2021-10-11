package org.techtown.fargment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var loginFragment:LoginFragment= LoginFragment()
    var menuFragment:MenuFragment= MenuFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoginButton.setOnClickListener{
            onFragmentChanged(0)
        }
        showMenuButton.setOnClickListener {
            onFragmentChanged(1)
        }
    }

    fun onFragmentChanged(index:Int){
        when(index){
            0->{
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,loginFragment)
                }.commit()
            }
            1->{
                with(supportFragmentManager.beginTransaction()){
                    replace(R.id.container,menuFragment)
                }.commit()
            }
        }
    }
}
