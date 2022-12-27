package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.databinding.FragmentSportBinding
import com.ozgursarki.newsapp.databinding.FragmentTabBinding


class SportFragment : Fragment() {

    private lateinit var binding: FragmentSportBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

}