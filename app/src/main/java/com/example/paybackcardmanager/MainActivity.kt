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
            startActivity(Intent(this, AddCardActivity::class.java))
        }
        
        // Zeige leeren Zustand an (vorerst)
        binding.emptyState.visibility = android.view.View.VISIBLE
        binding.recyclerViewCards.visibility = android.view.View.GONE
    }
}
