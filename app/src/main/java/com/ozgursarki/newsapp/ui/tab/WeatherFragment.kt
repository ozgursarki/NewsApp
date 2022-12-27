package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.databinding.FragmentTabBinding
import com.ozgursarki.newsapp.databinding.FragmentWeatherBinding


class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

}