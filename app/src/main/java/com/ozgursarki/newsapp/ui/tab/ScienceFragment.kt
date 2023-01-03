package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter
import com.ozgursarki.newsapp.databinding.FragmentScienceBinding
import com.ozgursarki.newsapp.ui.NewsFragmentDirections
import com.ozgursarki.newsapp.ui.viewmodel.ScienceFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ScienceFragment : Fragment() {

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

        val adapter = NewsFragmentAdapter(arrayListOf(), callback = {
            onClick(it)
        })
        binding.sciencerv.adapter = adapter

        viewModel.scienceNews.observe(viewLifecycleOwner,){scienceNews ->
            adapter.setNews(scienceNews)
        }

        viewModel.getScience()
    }

    fun onClick(url: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment2(url)
        findNavController().navigate(action)
    }
}