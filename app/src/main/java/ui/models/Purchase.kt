package ui.models

data class Purchase(
    val id: Int,
    val carName: String,
    val price: Double,
    val purchaseDate: String,
    val status: String
)
