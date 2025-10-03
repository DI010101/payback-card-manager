kotlin
package com.example.paybackcardmanager

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val cardNumber: String,
    val cardName: String,
    val barcodeType: String = "CODE_128"
)
