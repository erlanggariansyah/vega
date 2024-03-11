package com.erlanggariansyah.vega.activities

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.erlanggariansyah.vega.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBack: ImageView
    private lateinit var loginSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBack = findViewById(R.id.login_back)
        loginSubmit = findViewById(R.id.login_submit_button)
    }

    override fun onResume() {
        super.onResume()

        loginBack.setOnClickListener {
            val homeIntent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        }

        loginSubmit.setOnClickListener {
            val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Masuk")
            alertDialogBuilder.setMessage("Gagal masuk, username atau password tidak sesuai")
            alertDialogBuilder.setCancelable(false)
            alertDialogBuilder.setPositiveButton("OK") { dialog: DialogInterface?, _: Int ->
                dialog?.cancel()
            }

            alertDialogBuilder
                .create()
                .show()
        }
    }
}
