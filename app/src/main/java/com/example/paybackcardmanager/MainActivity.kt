private lateinit var cardManager: CardManager
private lateinit var adapter: CardAdapter

override fun onCreate(savedInstanceState: Bundle?) {
    // ...
    cardManager = CardManager(this)
    // ...
}

private fun loadCards() {
    val cards = cardManager.getCards()
    adapter.submitList(cards)
    if (cards.isEmpty()) {
        binding.emptyState.visibility = android.view.View.VISIBLE
        binding.recyclerViewCards.visibility = android.view.View.GONE
    } else {
        binding.emptyState.visibility = android.view.View.GONE
        binding.recyclerViewCards.visibility = android.view.View.VISIBLE
    }
}
