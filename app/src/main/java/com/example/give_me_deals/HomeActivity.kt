package com.example.give_me_deals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        frameLayout=findViewById(R.id.fLayout)

        bottomNav = findViewById(R.id.navigation) as BottomNavigationView
        loadFragment(HomeFragment())
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nearby -> {
                    loadFragment(NearbyFragment())
                    true
                }
                R.id.business -> {
                    loadFragment(BusinessFragment())
                    true
                }

                R.id.notification -> {
                    loadFragment(NotificationFragment())
                    true
                }

                R.id.myAccount -> {
                    loadFragment(MyAccountFragment())
                    true
                }
                else -> {loadFragment(HomeFragment())
                    true}
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fLayout,fragment)
        transaction.commit()
    }
    fun setBottomNav(itemId:Int){
        bottomNav.selectedItemId=itemId
    }

}