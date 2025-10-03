private lateinit var cardManager: CardManager

override fun onCreate(savedInstanceState: Bundle?) {
    // ...
    cardManager = CardManager(this)
    // ...
}

private fun saveCard() {
    // ...
    val card = Card(
        cardName = cardName,
        cardNumber = cardNumber,
        barcodeType = barcodeType
    )
    
    cardManager.saveCard(card)
    Toast.makeText(this, "Karte '$cardName' gespeichert!", Toast.LENGTH_SHORT).show()
    finish()
}
