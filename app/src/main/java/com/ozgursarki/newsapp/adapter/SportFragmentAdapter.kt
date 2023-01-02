package com.ozgursarki.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.model.everything.Article
import com.ozgursarki.newsapp.model.everything.Sport
import com.ozgursarki.newsapp.viewholder.SportViewHolder

class SportFragmentAdapter(private var sport: ArrayList<Article>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_sport_row,parent,false)
        return SportViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SportViewHolder).setSportNews(sport[position])
    }

    override fun getItemCount(): Int {
        return sport.size
    }

    fun setNews(newList: ArrayList<Article>){
        sport.clear()
        sport.addAll(newList)
        notifyDataSetChanged()
    }
}