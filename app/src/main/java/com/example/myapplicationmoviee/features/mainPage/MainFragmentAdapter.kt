package com.example.myapplicationmoviee.features.mainPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplicationmoviee.features.movieSaved.MovieSavedFragment
import com.example.myapplicationmoviee.features.movieSearch.MovieSearchFragment

class MainFragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {

        return when(position) {
            1 -> MovieSearchFragment()
            0 -> MovieSavedFragment()
            else -> MovieSearchFragment()
        }
    }

    override fun getCount(): Int = 2
}