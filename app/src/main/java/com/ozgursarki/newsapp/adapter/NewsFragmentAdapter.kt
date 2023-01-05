package com.ozgursarki.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.model.Article
import com.ozgursarki.newsapp.viewholder.SportViewHolder

class NewsFragmentAdapter(private var newsList: ArrayList<Article>, private var callback: (Article) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private  var isSaved : Boolean = false
    private var diffUtil = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = if(isSaved){
            LayoutInflater.from(parent.context).inflate(R.layout.save_row,parent,false)
        }else {
            LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        }
        return SportViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SportViewHolder).setSportNews(differ.currentList[position]) {
            callback.invoke(it)
        }
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}