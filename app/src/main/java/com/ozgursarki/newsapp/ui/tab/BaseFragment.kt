package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ozgursarki.newsapp.adapter.NewsFragmentAdapter
import com.ozgursarki.newsapp.model.Article

abstract class BaseFragment : Fragment(){
    protected lateinit var adapter : NewsFragmentAdapter

    abstract fun onClick(article: Article)

    abstract fun onSave(article: Article)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        NewsFragmentAdapter(arrayListOf()) {
            onClick(it)
            onSave(it)
        }.also { adapter = it }
    }





}