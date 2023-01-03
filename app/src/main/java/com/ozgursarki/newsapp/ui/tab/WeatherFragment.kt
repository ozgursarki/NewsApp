package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter
import com.ozgursarki.newsapp.databinding.FragmentWeatherBinding
import com.ozgursarki.newsapp.ui.viewmodel.WeatherFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger


@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherFragmentViewModel by viewModels()


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsFragmentAdapter(arrayListOf())
        binding.weatherrv.adapter = adapter

        viewModel.weatherNews.observe(viewLifecycleOwner,){weatherNews ->
            adapter.setNews(weatherNews)
        }

        viewModel.getWeather()

    }

}