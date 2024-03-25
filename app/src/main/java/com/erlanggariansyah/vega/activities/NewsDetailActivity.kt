package com.erlanggariansyah.vega.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erlanggariansyah.vega.databinding.ActivityNewsDetailBinding
import com.erlanggariansyah.vega.dto.News

class NewsDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val news = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("news", News::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("news")
        }

        if (news != null) {
            binding.newsDetailTitle.text = news.title
            binding.newsDetailCreatedDate.text = news.createdDate
            binding.newsDetailImage.setImageResource(news.image)
            binding.newsDetailSubtitle.text = news.subtitle
            binding.newsDetailDescription.text = news.description
        } else {
            val intent = Intent(this@NewsDetailActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        binding.newsDetailBack.setOnClickListener {
            val intent = Intent(this@NewsDetailActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
