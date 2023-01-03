package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter
import com.ozgursarki.newsapp.databinding.FragmentScienceBinding
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.extensions.navigate
import com.ozgursarki.newsapp.ui.NewsFragmentDirections
import com.ozgursarki.newsapp.ui.viewmodel.ScienceFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ScienceFragment : BaseFragment(),AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentScienceBinding
    private val viewModel: ScienceFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScienceBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.sciencerv.adapter = adapter

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

        viewModel.scienceNews.observe(viewLifecycleOwner,){scienceNews ->
            adapter.setNews(scienceNews)
        }

        viewModel.getScience()
    }

    override fun onClick(url: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment2(url)
        navigate(action)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item = p0?.getItemAtPosition(p2)
        when (item){
            LangType.German.name -> viewModel.getNews(LangType.German)
            LangType.Turkish.name -> viewModel.getNews(LangType.Turkish)
            LangType.English.name -> viewModel.getNews(LangType.English)
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}