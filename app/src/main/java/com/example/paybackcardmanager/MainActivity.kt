package com.example.paybackcardmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.paybackcardmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupUI()
    }
    
    private fun setupUI() {
        binding.fabAddCard.setOnClickListener {
            // Öffne AddCardActivity
            startActivity(Intent(this, AddCardActivity::class.java))
        }
        
        // Test: Direkt zur Barcode-Anzeige
        binding.emptyState.setOnClickListener {
            val intent = Intent(this, BarcodeDisplayActivity::class.java)
            startActivity(intent)
        }
        
        binding.emptyState.text = "Keine Karten gespeichert\n\nTippe auf + um eine Karte hinzuzufügen\n\nOder tippe hier um Test-Barcode anzuzeigen"
    }
}
