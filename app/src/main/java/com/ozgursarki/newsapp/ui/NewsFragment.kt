package com.ozgursarki.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsPagerAdapter
import com.ozgursarki.newsapp.databinding.FragmentNewsBinding
import com.ozgursarki.newsapp.enum.NewsType
import com.ozgursarki.newsapp.model.TabModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var viewpager2: ViewPager2
    private lateinit var adapter : NewsPagerAdapter
    private lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewpager2 = binding.viewPager2
        val fragmentList = listOf<TabModel>(
            TabModel(NewsType.SPORT),
            TabModel(NewsType.WEATHER),
            TabModel(NewsType.SCIENCE),
            TabModel(NewsType.SAVE)
        )
        adapter = NewsPagerAdapter(this,fragmentList)
        viewpager2.adapter = adapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout,viewpager2) { tab, position ->
            when(position) {
                0 -> tab.setCustomView(R.layout.ic_tab_sport)
                1 -> tab.setCustomView(R.layout.ic_tab_science)
                2 -> tab.setCustomView(R.layout.ic_tab_weather)
                3 -> tab.setCustomView(R.layout.ic_tab_savearticle)
            }

        }.attach()

    }




}