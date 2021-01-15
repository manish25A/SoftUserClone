package com.manish.softuserclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {
    private lateinit var coventryImg : ImageView
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var  tvforrgetpass : TextView
    private lateinit var btnIdLogin : Button
    private lateinit var etSignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        coventryImg = findViewById(R.id.coventryImg)
        etEmail =  findViewById(R.id.etEmail)
        etPassword =  findViewById(R.id.etPassword)
        btnIdLogin =  findViewById(R.id.btnIdlogin)
        etSignup =  findViewById(R.id.etSignup)
        btnIdLogin.setOnClickListener {
            if (etEmail.text.toString() == "softwarica" && etPassword.text.toString() == "coventry") {
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please Enter valid email or password", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}