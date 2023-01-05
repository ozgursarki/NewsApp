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
import com.ozgursarki.newsapp.data.local.toDataArticle
import com.ozgursarki.newsapp.databinding.FragmentSportBinding
import com.ozgursarki.newsapp.enum.LangType
import com.ozgursarki.newsapp.extensions.navigate
import com.ozgursarki.newsapp.model.Article
import com.ozgursarki.newsapp.ui.NewsFragmentDirections
import com.ozgursarki.newsapp.ui.viewmodel.SportFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SportFragment : BaseFragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentSportBinding
    private val viewmodel: SportFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

        viewmodel.sports.observe(viewLifecycleOwner) { sportList ->
            adapter.differ.submitList(sportList)

        }


        val recyclerview = binding.sportrv
        recyclerview.adapter = adapter

        getSportList()

    }

    private fun getSportList() {
        viewmodel.getSportNews()

    }

    override fun onClick(article: Article) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment2(article)
        navigate(action)
    }

    override fun onSave(article: Article) {
        viewmodel.insertArticle(article.toDataArticle())
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0?.getItemAtPosition(p2)){
            LangType.German.name -> viewmodel.getNews(LangType.German)
            LangType.Turkish.name -> viewmodel.getNews(LangType.Turkish)
            LangType.English.name -> viewmodel.getNews(LangType.English)
        }

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
