package com.erlanggariansyah.vega.activities

import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.adapters.home.ArticleAdapter
import com.erlanggariansyah.vega.adapters.home.NewsAdapter
import com.erlanggariansyah.vega.dto.Articles
import com.erlanggariansyah.vega.dto.News
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    private lateinit var login: View
    private lateinit var news: RecyclerView
    private lateinit var articles: RecyclerView
    private lateinit var articlesViewAll: TextView

    private lateinit var actionNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        actionNavigation = findViewById(R.id.home_action_navigation)

        articlesViewAll = findViewById(R.id.articles_view_all)

        login = findViewById(R.id.login)

        news = findViewById(R.id.news)
        articles = findViewById(R.id.articles)

        val newsData = ArrayList<News>()
        val articlesData = ArrayList<Articles>()

        val titles = resources.getStringArray(R.array.titles)
        val subtitles = resources.getStringArray(R.array.subtitles)
        val descriptions = resources.getStringArray(R.array.descriptions)

        val images = ArrayList<Int>()
        images.add(R.drawable.article_1)
        images.add(R.drawable.article_2)
        images.add(R.drawable.article_3)
        images.add(R.drawable.article_4)
        images.add(R.drawable.article_5)
        images.add(R.drawable.article_6)
        images.add(R.drawable.article_7)
        images.add(R.drawable.article_8)
        images.add(R.drawable.article_9)
        images.add(R.drawable.article_10)

        val createdDate = resources.getStringArray(R.array.created_dates)

        val articleTitles = resources.getStringArray(R.array.article_titles)
        val articleCreatedDates = resources.getStringArray(R.array.article_created_dates)

        for (i in images.indices)
            newsData.add(News(titles[i], subtitles[i], descriptions[i], images[i], createdDate[i]))

        for (j in articleTitles.indices)
            articlesData.add(Articles(articleTitles[j], articleCreatedDates[j], R.raw.article_1))

        val newsAdapter = NewsAdapter(newsData)
        val articlesAdapter = ArticleAdapter(articlesData)
        articlesAdapter.setShowedItem(5)

        news.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        news.adapter = newsAdapter

        articles.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        articles.adapter = articlesAdapter

        newsAdapter.setOnItemClickCallback(object: NewsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: News) {
                val intent = Intent(this@HomeActivity, NewsDetailActivity::class.java)
                intent.putExtra("news", data)

                startActivity(intent)
            }
        })

        actionNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_unitlink -> Toast.makeText(this, "Coming Soon", Toast.LENGTH_LONG).show()
                R.id.action_vega -> {
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivity(intent)

                    Toast.makeText(this, "VEGA E-Claim Policy with QR Scanner", Toast.LENGTH_LONG).show()
                }
                R.id.action_hospital -> Toast.makeText(this, "Coming Soon", Toast.LENGTH_LONG).show()
                R.id.action_profile -> {
                    startActivity(Intent(this@HomeActivity, ProfileActivity::class.java))
                }
            }

            true
        }
    }

    override fun onResume() {
        super.onResume()

        login.setOnClickListener {
            val loginIntent = Intent(this@HomeActivity, LoginActivity::class.java)
            startActivity(loginIntent)
        }

        articlesViewAll.setOnClickListener {
            val intent = Intent(this@HomeActivity, ArticleActivity::class.java)
            startActivity(intent)
        }
    }
}
