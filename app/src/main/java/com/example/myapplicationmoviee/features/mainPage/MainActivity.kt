package com.example.myapplicationmoviee.features.mainPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.myapplicationmoviee.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.movieSearchItem -> mainViewpager.currentItem = 1
            R.id.movieSaveItem -> mainViewpager.currentItem = 0
        }

        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()

    }

    private fun setupUI() {
        mainViewpager.adapter = MainFragmentAdapter(supportFragmentManager)
        mainBottomBar.setOnNavigationItemSelectedListener(this)
    }


    companion object {
        private const val TAG = "MainActivity"
    }

}
