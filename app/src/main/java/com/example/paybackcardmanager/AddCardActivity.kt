package com.example.paybackcardmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddCardActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        
        val btnSave = findViewById<Button>(R.id.btnSave)
        val etCardName = findViewById<EditText>(R.id.etCardName)
        val etCardNumber = findViewById<EditText>(R.id.etCardNumber)
        
        btnSave.setOnClickListener {
            val cardName = etCardName.text.toString().trim()
            val cardNumber = etCardNumber.text.toString().trim()
            
            if (cardName.isEmpty() || cardNumber.isEmpty()) {
                Toast.makeText(this, "Bitte fülle alle Felder aus", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            Toast.makeText(this, "Karte '$cardName' gespeichert!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
