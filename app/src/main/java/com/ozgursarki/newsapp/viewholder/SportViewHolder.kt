package com.ozgursarki.newsapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.model.Article
import com.squareup.picasso.Picasso

class SportViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    private val title = itemView.findViewById<TextView>(R.id.title)
    private val description = itemView.findViewById<TextView>(R.id.description)
    private val publishedAt = itemView.findViewById<TextView>(R.id.tvPublishedAt)

    fun setSportNews(sport: Article, callback: (Article) -> Unit){
        Picasso.get().load(sport.urlToImage).into(imageView)
        title.text = sport.title
        description.text = sport.description
        publishedAt.text = sport.publishedAt




        imageView.setOnClickListener {
            callback.invoke(sport)
        }





    }

}