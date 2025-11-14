package ui.models

import java.io.Serializable

data class Booking(
    val id: Int,
    val userId: Int,
    val vehicleName: String,
    val pickupDate: String,
    val returnDate: String
) : Serializable
