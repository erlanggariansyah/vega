package com.erlanggariansyah.vega.activities

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.erlanggariansyah.vega.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBack: ImageView
    private lateinit var loginSubmit: Button
    private lateinit var registerButton: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBack = findViewById(R.id.login_back)
        loginSubmit = findViewById(R.id.login_submit_button)
        registerButton = findViewById(R.id.register_button)
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

        val registerDialog = Dialog(this)
        registerButton.setOnClickListener {
            registerDialog.setContentView(R.layout.activity_login_register)
            registerDialog.window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            registerDialog.window?.attributes?.windowAnimations = R.style.animation

            val registerQR = registerDialog.findViewById<View>(R.id.register_qr)
            registerQR.setOnClickListener {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }

            val registerIndividual = registerDialog.findViewById<View>(R.id.register_individual)
            registerIndividual.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterIndividualActivity::class.java)
                startActivity(intent)
            }

            val registerCorporate = registerDialog.findViewById<View>(R.id.register_corporate)
            registerCorporate.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterCorporateActivity::class.java)
                startActivity(intent)
            }

            val registerDPLK = registerDialog.findViewById<View>(R.id.register_dplk)
            registerDPLK.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterDPLKActivity::class.java)
                startActivity(intent)
            }

            registerDialog.show()
        }
    }
}
