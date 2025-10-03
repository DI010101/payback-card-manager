package com.example.paybackcardmanager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paybackcardmanager.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: AppDatabase
    private lateinit var adapter: CardAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        database = AppDatabase.getInstance(this)
        setupRecyclerView()
        loadCards()
        
        binding.fabAddCard.setOnClickListener {
            startActivity(Intent(this, AddCardActivity::class.java))
        }
    }
    
    private fun setupRecyclerView() {
        adapter = CardAdapter { card ->
            val intent = Intent(this, BarcodeDisplayActivity::class.java).apply {
                putExtra("CARD_ID", card.id)
            }
            startActivity(intent)
        }
        
        binding.recyclerViewCards.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
    
    private fun loadCards() {
        lifecycleScope.launch {
            database.cardDao().getAllCards().collect { cards ->
                adapter.submitList(cards)
                if (cards.isEmpty()) {
                    binding.emptyState.visibility = android.view.View.VISIBLE
                } else {
                    binding.emptyState.visibility = android.view.View.GONE
                }
            }
        }
    }
    
    override fun onResume() {
        super.onResume()
        loadCards()
    }
}
