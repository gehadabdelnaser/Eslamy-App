package com.gehad.eslamy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_spalsh)

        startHomeActivity()
    }

    private fun startHomeActivity() {

        Handler().postDelayed({
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },1000)

    }
}
