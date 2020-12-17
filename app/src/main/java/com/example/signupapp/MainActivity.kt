package com.example.signupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail:EditText
    private lateinit var inputPassword:EditText
    private lateinit var submitButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEmail = findViewById(R.id.inputEmailEditText)
        inputPassword = findViewById(R.id.inputPasswordEditText)
        submitButton = findViewById(R.id.addNewAccountButton)
        mAuth = FirebaseAuth.getInstance()

        submitButton.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "ENTER CREDENTIALS!", Toast.LENGTH_LONG).show()

            }else{
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                Toast.makeText(this, "New Account Successfully Created", Toast.LENGTH_SHORT).show()
                            }else{

                                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                            }
                        }

            }
        }
    }
}