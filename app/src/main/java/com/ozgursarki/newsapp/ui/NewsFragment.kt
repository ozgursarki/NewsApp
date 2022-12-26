package com.ozgursarki.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsPagerAdapter
import com.ozgursarki.newsapp.databinding.FragmentNewsBinding

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
        adapter = NewsPagerAdapter(this,4)
        viewpager2.adapter = adapter
        recyclerView = binding.recyclerviewNews
        binding.recyclerviewNews.adapter = adapter


        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout,viewpager2) { tab, position ->
            tab.text = "GUN ${(position + 1)}"
        }.attach()
    }


}