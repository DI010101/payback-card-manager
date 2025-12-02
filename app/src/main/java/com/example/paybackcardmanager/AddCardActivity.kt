package com.example.paybackcardmanager

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.paybackcardmanager.databinding.ActivityAddCardBinding

class AddCardActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityAddCardBinding
    private lateinit var cardManager: CardManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        cardManager = CardManager(this)
        
        setupClickListeners()
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
        
        val card = Card(
            cardName = cardName,
            cardNumber = cardNumber,
            barcodeType = "CODE_128"
        )
        
        cardManager.saveCard(card)
        Toast.makeText(this, "Karte '$cardName' gespeichert!", Toast.LENGTH_SHORT).show()
        finish()
    }
}
