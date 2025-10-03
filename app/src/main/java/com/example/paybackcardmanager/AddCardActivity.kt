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
        val barcodeType = when {
            binding.radioCode128.isChecked -> "CODE_128"
            binding.radioQrCode.isChecked -> "QR_CODE"
            else -> "CODE_128"
        }
        
        if (cardName.isEmpty() || cardNumber.isEmpty()) {
            Toast.makeText(this, "Bitte fülle alle Felder aus", Toast.LENGTH_SHORT).show()
            return
        }
        
        val card = Card(
            cardName = cardName,
            cardNumber = cardNumber,
            barcodeType = barcodeType
        )
        
        cardManager.saveCard(card)
        Toast.makeText(this, "Karte '$cardName' gespeichert!", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
