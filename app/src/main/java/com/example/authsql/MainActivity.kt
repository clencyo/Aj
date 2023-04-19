package com.example.authsql

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var firstname:EditText
    lateinit var secondname:EditText
    lateinit var email_edit:EditText
    lateinit var password_edit:EditText
    lateinit var acount_create:Button
    lateinit var loginbutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        firstname = findViewById(R.id.edtfirst)
        secondname = findViewById(R.id.edtsecond)
        email_edit = findViewById(R.id.edtemail)
        password_edit = findViewById(R.id.edtpassword)
        acount_create = findViewById(R.id.btnacount)
        loginbutton = findViewById(R.id.btnlogin)

        var db = openOrCreateDatabase("AUDIAdb", MODE_PRIVATE, null)

        //creating table
        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho INTAGER)")

        loginbutton.setOnClickListener {
            //Receive data from the user
            var firsname = firstname.text.toString()
            var secname = secondname.text.toString()
            var email = email_edit.text.toString()
            var password = password_edit.text.toString()
            //Check if the user is trying to submit empty records
            if (firsname.isEmpty() or email.isEmpty() or password.isEmpty() or secname.isEmpty()){
                //Use the display_message() to Display a message telling the user to fill all the inputs

                //toast a message to say cannot submit empty field
                Toast.makeText(this, "Cannot Submit empty Field", Toast.LENGTH_SHORT).show()
            }else{
                //Proceed to save your data into the db
                db.execSQL("INSERT INTO users VALUES('"+firsname+"','"+email+"','"+secname+"','"+password+"')")

                //Toast a success message

                Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()

                //navigating a user from one activity to the other
                var gotologin = Intent(this, login_activity::class.java)
                startActivity(gotologin)
            }



        }

    }
}