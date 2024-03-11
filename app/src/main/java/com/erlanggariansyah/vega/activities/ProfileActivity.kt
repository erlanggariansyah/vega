package com.erlanggariansyah.vega.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.erlanggariansyah.vega.R

class ProfileActivity : AppCompatActivity() {
    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        back = findViewById(R.id.profile_back)
    }

    override fun onResume() {
        super.onResume()

        back.setOnClickListener {
            startActivity(Intent(this@ProfileActivity, HomeActivity::class.java))
            finish()
        }
    }
}
