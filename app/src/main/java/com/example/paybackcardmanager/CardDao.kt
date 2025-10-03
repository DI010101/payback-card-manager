package com.example.paybackcardmanager

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CardDao {
    @Query("SELECT * FROM cards ORDER BY cardName")
    fun getAllCards(): Flow<List<Card>>
    
    @Insert
    suspend fun insertCard(card: Card)
    
    @Delete
    suspend fun deleteCard(card: Card)
    
    @Query("SELECT * FROM cards WHERE id = :cardId")
    suspend fun getCardById(cardId: Long): Card?
}
