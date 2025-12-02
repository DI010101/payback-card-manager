package com.example.paybackcardmanager

data class Card(
    val id: Long = 0,
    val cardNumber: String,
    val cardName: String,
    val barcodeType: String = "CODE_128"
)
