package com.ozgursarki.newsapp.ui.tab

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozgursarki.newsapp.databinding.FragmentPoliticaBinding
import com.ozgursarki.newsapp.databinding.FragmentTabBinding


class PoliticaFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentPoliticaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPoliticaBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

}