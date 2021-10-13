package com.aisyah.hotelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aisyah.hotelapp.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item  ->
        when (item.itemId){
            R.id.nav_home -> {
                val homeFragment = HomeFragment()
                addFragment (homeFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_booking -> {
                val bookingFragment = BookingFragment()
                addFragment (bookingFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_map -> {
                val inboxFragment = InboxFragment()
                addFragment (inboxFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_history -> {
                val historyFragment = HistoryFragment()
                addFragment (historyFragment)
                return@OnNavigationItemSelectedListener true
            }

            R.id.nav_profile -> {
                val profileFragment = ProfileFragment()
                addFragment (profileFragment)
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fm_main_container, fragment, fragment::class.java.simpleName)
            .addToBackStack(null).commit()
    }

    val defaultMainView = HomeFragment.defaultFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        nav_main.setOnNavigationItemSelectedListener  (onNavigationItemSelectedListener)
        addFragment(defaultMainView)
    }


}