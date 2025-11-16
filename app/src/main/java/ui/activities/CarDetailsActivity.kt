package com.example.cruisemastersmad.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cruisemastersmad.R
import com.example.cruisemastersmad.databinding.ActivityCarDetailsBinding
import com.example.cruisemastersmad.ui.models.Car
import java.io.Serializable

class CarDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the car object from the intent using Serializable
        val car = intent.getSerializableExtra("car") as? Car
        car?.let { displayCarDetails(it) }

        setupClickListeners()
    }

    private fun displayCarDetails(car: Car) {
        binding.carImage.setImageResource(car.imageResId)
        binding.carName.text = car.name
        binding.carMileage.text = car.mileage
        binding.carPrice.text = "$${car.price}"

        // Placeholder image since Car.kt has no image
        binding.carImage.setImageResource(R.drawable.logo2)
    }

    private fun setupClickListeners() {
        binding.bookButton.setOnClickListener {
            // Navigate to booking screen
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
