package com.example.cruisemastersmad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cruisemastersmad.databinding.ActivityCarDetailsBinding
import com.example.cruisemastersmad.models.Car

class CarDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCarDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val car = intent.getParcelableExtra<Car>("car")
        car?.let { displayCarDetails(it) }

        setupClickListeners()
    }

    private fun displayCarDetails(car: Car) {
        binding.carName.text = car.name
        binding.carBrand.text = car.brand
        binding.carPrice.text = "$${car.price}/day"
        binding.carDescription.text = car.description
        binding.horsepowerValue.text = "${car.horsepower} HP"
        binding.accelerationValue.text = "${car.acceleration}s 0-60"
        binding.topSpeedValue.text = "${car.topSpeed} mph"

        // Load image - for now using placeholder
        binding.carImage.setImageResource(car.imageResId)
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