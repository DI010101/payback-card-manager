private lateinit var cardManager: CardManager

override fun onCreate(savedInstanceState: Bundle?) {
    // ...
    cardManager = CardManager(this)
    // ...
}

private fun loadAndDisplayCard(cardId: Long) {
    val card = cardManager.getCardById(cardId)
    if (card != null) {
        cardNameText.text = card.cardName
        displayBarcode(card.cardNumber, card.barcodeType)
    } else {
        Toast.makeText(this, "Karte nicht gefunden", Toast.LENGTH_SHORT).show()
        finish()
    }
}
