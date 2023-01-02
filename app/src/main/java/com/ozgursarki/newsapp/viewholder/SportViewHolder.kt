package com.ozgursarki.newsapp.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ozgursarki.newsapp.R
import com.ozgursarki.newsapp.model.everything.Article
import com.ozgursarki.newsapp.model.everything.Sport
import com.squareup.picasso.Picasso

class SportViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    val title = itemView.findViewById<TextView>(R.id.title)
    val description = itemView.findViewById<TextView>(R.id.description)

    fun setSportNews(sport: Article){
        Picasso.get().load(sport.urlToImage).into(imageView)
        title.text = sport.title
        description.text = sport.description

    }

}