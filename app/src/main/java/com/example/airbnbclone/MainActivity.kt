package com.example.airbnbclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.airbnbclone.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exploreFragment = ExploreFragment()
        val wishlistFragment = WishlistFragment()
        val tripFragment = TripFragment()
        val inboxFragment = InboxFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(exploreFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.explore ->makeCurrentFragment(exploreFragment)
                R.id.wishlist ->makeCurrentFragment(wishlistFragment)
                R.id.trip ->makeCurrentFragment(tripFragment)
                R.id.inbox ->makeCurrentFragment(inboxFragment)
                R.id.profile ->makeCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
supportFragmentManager.beginTransaction().apply {
    replace(R.id.fl_wrapper, fragment)
    commit()
}
    }


}
