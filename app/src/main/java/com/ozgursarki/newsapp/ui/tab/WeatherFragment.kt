package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.databinding.FragmentWeatherBinding
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.extensions.navigate
import com.ozgursarki.newsapp.model.Article
import com.ozgursarki.newsapp.ui.NewsFragmentDirections
import com.ozgursarki.newsapp.ui.viewmodel.WeatherFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentWeatherBinding
    private val viewModel: WeatherFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.weatherrv.adapter = adapter

        val spinner: Spinner = binding.langSpinner
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.language,
            androidx.transition.R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        viewModel.weatherNews.observe(viewLifecycleOwner){weatherNews ->
            adapter.differ.submitList(weatherNews)
        }

        viewModel.getWeather()

    }

    override fun onClick(article: Article) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment2(article)
        navigate(action)
    }

    override fun onSave(article: Article) {
        TODO("Not yet implemented")
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0?.getItemAtPosition(p2)){
            LangType.German.name -> viewModel.getNews(LangType.German)
            LangType.Turkish.name -> viewModel.getNews(LangType.Turkish)
            LangType.English.name -> viewModel.getNews(LangType.English)
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}