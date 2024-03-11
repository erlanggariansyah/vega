package com.erlanggariansyah.vega.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.adapters.home.ArticleAdapter
import com.erlanggariansyah.vega.adapters.home.NewsAdapter
import com.erlanggariansyah.vega.dto.Articles
import com.erlanggariansyah.vega.dto.News

class HomeActivity : AppCompatActivity() {
    private lateinit var login: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        login = findViewById(R.id.login)

        val news: RecyclerView = findViewById(R.id.news)
        val articles: RecyclerView = findViewById(R.id.articles)

        val newsData = ArrayList<News>()
        val articlesData = ArrayList<Articles>()

        val titles = resources.getStringArray(R.array.titles)
        val subtitles = resources.getStringArray(R.array.subtitles)
        val descriptions = resources.getStringArray(R.array.descriptions)
        val images = resources.getIntArray(R.array.images)
        val createdDate = resources.getStringArray(R.array.created_dates)

        val articleTitles = resources.getStringArray(R.array.article_titles)
        val articleCreatedDates = resources.getStringArray(R.array.article_created_dates)

        for (i in images.indices)
            newsData.add(News(titles[i], subtitles[i], descriptions[i], images[i], createdDate[i]))

        for (j in articleTitles.indices)
            articlesData.add(Articles(articleTitles[j], articleCreatedDates[j], R.raw.article_1))

        news.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        news.adapter = NewsAdapter(newsData)

        articles.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        articles.adapter = ArticleAdapter(articlesData)
    }

    override fun onResume() {
        super.onResume()

        login.setOnClickListener {
            val loginIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }
}
