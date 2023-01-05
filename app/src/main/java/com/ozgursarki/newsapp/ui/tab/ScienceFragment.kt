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
import com.ozgursarki.newsapp.databinding.FragmentScienceBinding
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.model.Article
import com.ozgursarki.newsapp.ui.viewmodel.ScienceFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ScienceFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentScienceBinding
    private val viewModel: ScienceFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClick(article: Article) {

    }

    override fun onSave(article: Article) {
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




        viewModel.scienceNews.observe(viewLifecycleOwner){scienceNews ->
            adapter.differ.submitList(scienceNews)
        }

        viewModel.getScience()
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