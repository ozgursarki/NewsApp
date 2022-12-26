package com.ozgursarki.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ozgursarki.newsapp.ui.tab.TabFragment

class NewsPagerAdapter(fragment : Fragment, private val tabCount : Int ) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        return TabFragment()
    }
}