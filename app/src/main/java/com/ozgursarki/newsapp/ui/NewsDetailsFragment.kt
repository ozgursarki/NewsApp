package com.ozgursarki.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsPagerAdapter
import com.ozgursarki.newsapp.databinding.FragmentNewsDetailsBinding

class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailsBinding.inflate(inflater,container,false)
        val adapter = NewsPagerAdapter(this,4)
        binding.recyclerviewDetails.adapter = adapter
        val view = binding.root
        return view
    }

}