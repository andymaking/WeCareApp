package io.king.wecareapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import io.king.wecareapp.data.UserPreferences
import io.king.wecareapp.ui.auth.AuthActivity
import io.king.wecareapp.ui.home.HomeActivity
import io.king.wecareapp.ui.starttNewActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPreferences = UserPreferences(this)

        userPreferences.authToken.asLiveData().observe(this, Observer{
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            starttNewActivity(activity)
        })
    }
}