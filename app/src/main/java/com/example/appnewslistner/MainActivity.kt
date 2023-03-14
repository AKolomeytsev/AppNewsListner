package com.example.appnewslistner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appnewslistner.feature.news_screen.MainScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.screensContener, MainScreenFragment())
            .commit()
    }
}