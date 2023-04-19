package com.example.authsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class login_activity : AppCompatActivity() {

    lateinit var email_login: EditText
    lateinit var password_login: EditText
    lateinit var login_login: EditText
    lateinit var create_button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.emailedt)
        password_login = findViewById(R.id.passwordedt)
        login_login = findViewById(R.id.btnforlogin)
        create_button =findViewById(R.id.btnregister)

        login_login.setOnClickListener {
            val gotoCreateAcount = Intent(this,MainActivity::class.java)
            startActivity(gotoCreateAcount)
        }

        create_button.setOnClickListener {
            val gotoLogin = Intent(this,MainActivity::class.java)
            startActivity(gotoLogin)
        }



    }
}