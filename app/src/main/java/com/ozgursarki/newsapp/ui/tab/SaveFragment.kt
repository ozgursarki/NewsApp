package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.databinding.FragmentSaveBinding
import com.ozgursarki.newsapp.databinding.FragmentSportBinding
import com.ozgursarki.newsapp.model.everything.Article
import com.ozgursarki.newsapp.ui.viewmodel.SaveFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : BaseFragment() {

    private lateinit var binding: FragmentSaveBinding
    private val viewmodel : SaveFragmentViewModel by viewModels()

    override fun onClick(article:Article) {
        TODO("Not yet implemented")
    }

    override fun onSave(article: Article) {
        TODO("Not yet implemented")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saverv.adapter = adapter

        viewmodel.savedNews.observe(viewLifecycleOwner){
            adapter.setNews(it)
        }

        viewmodel.getSavedNews()


    }


}