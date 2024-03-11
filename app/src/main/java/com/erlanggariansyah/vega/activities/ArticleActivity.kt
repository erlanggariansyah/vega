package com.erlanggariansyah.vega.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.adapters.home.ArticleAdapter
import com.erlanggariansyah.vega.dto.Articles

class ArticleActivity : AppCompatActivity() {
    private lateinit var articles: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        articles = findViewById(R.id.articles)

        val articlesData = ArrayList<Articles>()

        val articleTitles = resources.getStringArray(R.array.article_titles)
        val articleCreatedDates = resources.getStringArray(R.array.article_created_dates)

        for (i in articleTitles.indices) {
            articlesData.add(Articles(articleTitles[i], articleCreatedDates[i], R.raw.article_1))
        }

        val articlesAdapter = ArticleAdapter(articlesData)

        articles.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        articles.adapter = articlesAdapter
    }
}
