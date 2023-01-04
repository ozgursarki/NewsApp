package com.ozgursarki.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ozgursarki.newsapp.enum.NewsType
import com.ozgursarki.newsapp.model.TabModel
import com.ozgursarki.newsapp.ui.tab.SaveFragment
import com.ozgursarki.newsapp.ui.tab.ScienceFragment
import com.ozgursarki.newsapp.ui.tab.SportFragment
import com.ozgursarki.newsapp.ui.tab.WeatherFragment

class NewsPagerAdapter(fragment : Fragment, private val fragmentList: List<TabModel>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(fragmentList[position].newsType){
            NewsType.SCIENCE -> ScienceFragment()
            NewsType.SPORT -> SportFragment()
            NewsType.WEATHER -> WeatherFragment()
            NewsType.SAVE -> SaveFragment()
        }
    }
}