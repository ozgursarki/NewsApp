package com.ozgursarki.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.model.everything.Article
import com.ozgursarki.newsapp.viewholder.SportViewHolder

class NewsFragmentAdapter(private var newsList: ArrayList<Article>, var callback: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return SportViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SportViewHolder).setSportNews(newsList[position]) {
            callback.invoke(it)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun setNews(newList: ArrayList<Article>){
        newsList.clear()
        newsList.addAll(newList)
        notifyDataSetChanged()
    }
}