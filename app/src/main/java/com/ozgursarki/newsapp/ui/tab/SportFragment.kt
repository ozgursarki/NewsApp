package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter
import com.ozgursarki.newsapp.databinding.FragmentSportBinding
import com.ozgursarki.newsapp.ui.NewsFragmentDirections
import com.ozgursarki.newsapp.ui.viewmodel.SportFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SportFragment : Fragment() {

    private lateinit var binding: FragmentSportBinding
    private lateinit var adapter: NewsFragmentAdapter
    private val viewmodel: SportFragmentViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NewsFragmentAdapter(arrayListOf(), { url ->
            onClick(url)

        })

        viewmodel.sports.observe(viewLifecycleOwner) { sportList ->
            adapter.setNews(sportList)

        }


        val recyclerview = binding.sportrv
        recyclerview.adapter = adapter

        getSportList()

    }

    fun getSportList() {
        viewmodel.getSportNews()

    }

    fun onClick(url: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment2(url)
        findNavController().navigate(action)
    }
}
