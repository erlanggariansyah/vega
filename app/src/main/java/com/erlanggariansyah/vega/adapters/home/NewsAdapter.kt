package com.erlanggariansyah.vega.adapters.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.dto.News

class NewsAdapter(private val news: ArrayList<News>): RecyclerView.Adapter<NewsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback{
        fun onItemClicked(data: News)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.news_item_title)
        val subtitle: TextView = itemView.findViewById(R.id.news_item_subtitle)
        val thumbnail: ImageView = itemView.findViewById(R.id.news_item_thumbnail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder = ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_home_news_item, parent, false))

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, subtitle, description, image, createdDate) = news[position]
        holder.title.text = title
        holder.subtitle.text = subtitle
        holder.thumbnail.setImageResource(image)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(news[holder.adapterPosition]) }
    }
}
