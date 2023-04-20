package com.example.authsql

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_activity : AppCompatActivity() {

    lateinit var email_login: EditText
    lateinit var password_login: EditText
    lateinit var login_login: EditText
    lateinit var create_button: Button
    lateinit var db:SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email_login = findViewById(R.id.emailedt)
        password_login = findViewById(R.id.passwordedt)
        login_login = findViewById(R.id.btnforlogin)
        create_button =findViewById(R.id.btnregister)

        var db = openOrCreateDatabase("AUDIAdb", MODE_PRIVATE, null)

        login_login.setOnClickListener {
            var email = email_login.text.toString().trim()
            var password = password_login.text.toString().trim()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Cannot Submit", Toast.LENGTH_SHORT).show()

            } else {
                val cursor = db.rawQuery(
                    "SELECT * FROM users WHERE arafa=? AND siri=?",
                    arrayOf(email, password)
                )

                if (cursor != null && cursor.moveToFirst()) {
                    // user is authenticated, start a new activity
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this, "Invalid email or password, please try again",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }




    }
}