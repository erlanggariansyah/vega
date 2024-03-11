package com.erlanggariansyah.vega.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.erlanggariansyah.vega.R
import com.erlanggariansyah.vega.dto.News

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var createdDate: TextView
    private lateinit var image: ImageView
    private lateinit var subtitle: TextView
    private lateinit var description: TextView

    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        title = findViewById(R.id.news_detail_title)
        createdDate = findViewById(R.id.news_detail_created_date)
        image = findViewById(R.id.news_detail_image)
        subtitle = findViewById(R.id.news_detail_subtitle)
        description = findViewById(R.id.news_detail_description)

        back = findViewById(R.id.news_detail_back)

        val news = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("news", News::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("news")
        }

        if (news != null) {
            title.text = news.title
            createdDate.text = news.createdDate
            image.setImageResource(news.image)
            subtitle.text = news.subtitle
            description.text = news.description
        } else {
            val intent = Intent(this@NewsDetailActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        back.setOnClickListener {
            val intent = Intent(this@NewsDetailActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
