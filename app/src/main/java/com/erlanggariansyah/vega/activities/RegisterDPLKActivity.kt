package com.erlanggariansyah.vega.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.erlanggariansyah.vega.R

class RegisterDPLKActivity : AppCompatActivity() {
    private lateinit var registerBack: ImageView
    private lateinit var login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_dplk)

        registerBack = findViewById(R.id.register_back)
        login = findViewById(R.id.login_button)
    }

    override fun onResume() {
        super.onResume()

        registerBack.setOnClickListener {
            val intent = Intent(this@RegisterDPLKActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        login.setOnClickListener {
            val intent = Intent(this@RegisterDPLKActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
