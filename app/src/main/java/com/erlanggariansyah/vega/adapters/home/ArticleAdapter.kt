package com.erlanggariansyah.vega.adapters.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.dto.Articles

class ArticleAdapter(private val articles: ArrayList<Articles>): RecyclerView.Adapter<ArticleAdapter.ListViewHolder>() {
    private var showedItem: Int = articles.size

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.home_article_title)
        val createdDate: TextView = itemView.findViewById(R.id.home_article_created_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_home_articles_item, parent, false))

    override fun getItemCount(): Int = showedItem

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, createdDate, file) = articles[position]
        holder.title.text = title
        holder.createdDate.text = createdDate
    }

    fun setShowedItem(showedItem: Int) {
        this.showedItem = showedItem
    }
}
