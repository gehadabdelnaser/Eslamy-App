package com.gehad.eslamy

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.gehad.base.BaseActivity
import com.gehad.eslamy.fragment.AhadethFragment
import com.gehad.eslamy.fragment.QuranFragment
import com.gehad.eslamy.fragment.RadioFragment
import com.gehad.eslamy.fragment.TasbehFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        nav_view.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    var fragment :Fragment?=null

                    when (item.itemId) {
                        R.id.navigation_quran -> {
                            fragment=QuranFragment()
                        }
                        R.id.navigation_tasbeh -> {
                            fragment=TasbehFragment()
                        }
                        R.id.navigation_ahadeth -> {
                            fragment=AhadethFragment()
                        }
                        R.id.navigation_radio -> {
                            fragment=RadioFragment()
                        }
                    }

                    supportFragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                            ,R.anim.enter_left_to_right,R.anim.exit_left_to_right)
                        .replace(R.id.fragment_contaner , fragment?:QuranFragment())
                        .commit()
                    return true
                }
            })
        nav_view.selectedItemId=R.id.navigation_quran

    }
}
