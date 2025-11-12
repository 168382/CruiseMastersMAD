package com.example.cruisemastersmad.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val id: Int,
    val name: String,
    val brand: String,
    val price: Double,
    val imageResId: Int,
    val imageUrl: String? = null,
    val description: String,
    val features: List<String>,
    val horsepower: Int,
    val acceleration: Double,
    val topSpeed: Int
) : Parcelable

@Parcelize
data class Booking(
    val id: Int,
    val carId: Int,
    val carName: String,
    val startDate: String,
    val endDate: String,
    val totalPrice: Double,
    val status: String
) : Parcelable

@Parcelize
data class Purchase(
    val id: Int,
    val carName: String,
    val amount: Double,
    val date: String,
    val status: String
) : Parcelable