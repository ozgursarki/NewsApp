package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter

abstract class BaseFragment : Fragment(){
    protected lateinit var adapter : NewsFragmentAdapter

    abstract fun onClick(url: String)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsFragmentAdapter(arrayListOf(), { url ->
            onClick(url)

        })
    }





}