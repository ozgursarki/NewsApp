package com.ozgursarki.newsapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ozgursarki.newsapp.databinding.FragmentNewsDetailsBinding
import com.ozgursarki.newsapp.ui.viewmodel.NewsDetailsFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment() {

    private lateinit var binding: FragmentNewsDetailsBinding
    private  val viewmodel: NewsDetailsFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    val args: NewsDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener { viewmodel.saveArticle(args.article) }
        webViewSetup(args.article.url!!)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup(url : String){
        binding.webview.webViewClient = WebViewClient()

        binding.webview.apply {
            loadUrl(url)
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }
    }



}