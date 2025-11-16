package com.example.cruisemastersmad.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val id: Int,
    val name: String,
    val mileage: String,
    val price: Int,
    val imageResId: Int
) : Parcelable
