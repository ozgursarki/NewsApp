package com.ozgursarki.newsapp.ui.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.data.local.toDataArticle
import com.ozgursarki.newsapp.databinding.FragmentSaveBinding
import com.ozgursarki.newsapp.model.Article
import com.ozgursarki.newsapp.ui.viewmodel.SaveFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : BaseFragment() {

    private lateinit var binding: FragmentSaveBinding
    private val viewmodel : SaveFragmentViewModel by viewModels()

    override fun onClick(article: Article) {
        TODO("Not yet implemented")
    }

    override fun onSave(article: Article) {
        TODO("Not yet implemented")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSaveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saverv.adapter = adapter

        viewmodel.savedNews.observe(viewLifecycleOwner){
            adapter.differ.submitList(it.toList())
        }

        viewmodel.getSavedNews()

        val swipeCallback = object: ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val list = mutableListOf<Article>()

                adapter.differ.currentList.toMutableList().map {
                    val article = it.copy()
                    list.add(article)
                }
                viewmodel.deleteArticle(list[position].toDataArticle())
                list.removeAt(position)

                adapter.differ.submitList(list)


            }



        }

        ItemTouchHelper(swipeCallback).apply {
            attachToRecyclerView(binding.saverv)
        }

    }




}