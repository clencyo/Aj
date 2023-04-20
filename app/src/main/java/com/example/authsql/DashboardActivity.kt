package com.example.authsql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {

    lateinit var logoutbutton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        logoutbutton = findViewById(R.id.btnlogout)

        logoutbutton.setOnClickListener {

            //navigating a user from one activity to the other
            var gotologout = Intent(this, MainActivity::class.java)
            startActivity(gotologout)
        }
    }
}