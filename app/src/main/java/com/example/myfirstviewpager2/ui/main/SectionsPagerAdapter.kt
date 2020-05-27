package com.example.myfirstviewpager2.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myfirstviewpager2.MainActivity
import com.example.myfirstviewpager2.R
import com.example.myfirstviewpager2.fragments.Placeholder1Fragment
import com.example.myfirstviewpager2.fragments.Placeholder2Fragment
import com.example.myfirstviewpager2.fragments.Placeholder3Fragment

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment = when (position) {
        FIRST_SCREEN_POSITION -> Placeholder1Fragment.newInstance(1)
        SECOND_SCREEN_POSITION -> Placeholder2Fragment.newInstance(2)
        THIRD_SCREEN_POSITION -> Placeholder3Fragment.newInstance(1)
        else -> throw IllegalStateException("Invalid adapter position")
    }

    override fun getItemCount(): Int {
        // Show 2 total pages.
        return TRANSACTION_SCREENS_NUMBER
    }
    companion object{
        internal const val TRANSACTION_SCREEN_OFFSCREEN_LIMIT = 2
        internal const val TRANSACTION_SCREENS_NUMBER = 3

        internal const val FIRST_SCREEN_POSITION = 0
        internal const val SECOND_SCREEN_POSITION = 1
        internal const val THIRD_SCREEN_POSITION = 2
    }
}