package com.example.airbnbclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        tvName.text = currentUser?.displayName
        Glide.with(this).load(currentUser?.photoUrl).into(ivProfile);

        btnLogOut.setOnClickListener {
            mAuth.signOut()
            val intent =Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}