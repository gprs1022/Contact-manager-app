package com.example.contactmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class contactAddactivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_addactivity)

        supportActionBar?.hide()

        val signUpButton = findViewById<Button>(R.id.addContact)
        val userName    = findViewById<TextInputEditText>(R.id.etName)
        val userMail   = findViewById<TextInputEditText>(R.id.etEmail)
        val userContact = findViewById<TextInputEditText>(R.id.etContact)


        signUpButton.setOnClickListener {

            val name = userName.text.toString()
            val mail = userMail.text.toString()

            val usrContact = userContact.text.toString()

            val contact = Contact(name, mail, usrContact)

            database = FirebaseDatabase.getInstance().getReference("Contact")

            database.child(usrContact).setValue(contact).addOnSuccessListener {


                Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
            }

        }



    }
}