package com.example.appnewslistner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appnewslistner.feature.bookmarks.ui.BookmarksFragment
import com.example.appnewslistner.feature.news_screen.MainScreenFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val bottomNavigationMenu: BottomNavigationView by lazy{findViewById(R.id.bnvBar)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationMenu.setOnItemSelectedListener{
            when(it.itemId){
                R.id.itemMain->{
                    selectetdTab(MainScreenFragment())
                }
                R.id.itemBookmarks->{
                    selectetdTab(BookmarksFragment())
                }
                else->{}

            }
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.itemMain
    }

    private fun selectetdTab(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.screensContener, fragment)
            .commit()
    }
}




