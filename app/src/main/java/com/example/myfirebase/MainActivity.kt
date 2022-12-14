package com.example.myfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        butregistr.setOnClickListener {
            val email=editTextemail.text.toString()
            val password=editTextpassword.text.toString()
            if (email.isEmpty() ||password.isEmpty()){
                Toast.makeText(this,"ცარიელია!",Toast.LENGTH_SHORT).show()
            }else if(email.length<7 ||password.length<6){
                    Toast.makeText(this,"არასწორი შეყვანა!",Toast.LENGTH_SHORT).show()}
            else{
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "დაფიქსირდა შეცდომა!", Toast.LENGTH_SHORT).show()
                        }
                    }
        }
            editTextemail.text.clear()
           editTextpassword.text.clear()
            }
      
        }
    }
