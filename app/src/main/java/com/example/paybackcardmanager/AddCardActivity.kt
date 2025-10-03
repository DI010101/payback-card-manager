        package com.example.paybackcardmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.paybackcardmanager.databinding.ActivityAddCardBinding

class AddCardActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAddCardBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupClickListeners()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Karte hinzufügen"
    }
    
    private fun setupClickListeners() {
        binding.btnSave.setOnClickListener {
            saveCard()
        }
    }
    
    private fun saveCard() {
        val cardName = binding.etCardName.text.toString().trim()
        val cardNumber = binding.etCardNumber.text.toString().trim()
        
        if (cardName.isEmpty() || cardNumber.isEmpty()) {
            Toast.makeText(this, "Bitte fülle alle Felder aus", Toast.LENGTH_SHORT).show()
            return
        }
        
        // Zeige Erfolgsmeldung (ohne Datenbank)
        Toast.makeText(this, "Karte '$cardName' würde gespeichert werden", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
