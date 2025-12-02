package com.example.paybackcardmanager

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardManager(private val context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("payback_cards", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    fun saveCard(card: Card) {
        val cards = getCards().toMutableList()
        cards.add(card.copy(id = System.currentTimeMillis()))
        saveCards(cards)
    }
    
    fun getCards(): List<Card> {
        val cardsJson = sharedPreferences.getString("cards", "[]")
        val type = object : TypeToken<List<Card>>() {}.type
        return gson.fromJson(cardsJson, type) ?: emptyList()
    }
    
    private fun saveCards(cards: List<Card>) {
        val cardsJson = gson.toJson(cards)
        sharedPreferences.edit().putString("cards", cardsJson).apply()
    }
    
    fun getCardById(cardId: Long): Card? {
        return getCards().find { it.id == cardId }
    }
}
