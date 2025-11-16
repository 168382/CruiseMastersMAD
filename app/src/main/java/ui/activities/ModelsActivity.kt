package com.example.cruisemastersmad.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cruisemastersmad.databinding.ActivityModelsBinding
import com.example.cruisemastersmad.activities.CarDetailsActivity
import com.example.cruisemastersmad.ui.adapters.CarAdapter
import com.example.cruisemastersmad.ui.models.Car

class ModelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityModelsBinding
    private lateinit var carAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        carAdapter = CarAdapter(getSampleCars()) { car ->
            // Handle car item click - navigate to car details
            val intent = Intent(this, CarDetailsActivity::class.java)
            intent.putExtra("car", car)
            startActivity(intent)
        }

        binding.carsRecyclerView.apply {
            layoutManager = GridLayoutManager(this@ModelsActivity, 2)
            adapter = carAdapter
        }
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterCars(newText)
                return true
            }
        })
    }

    private fun filterCars(query: String?) {
        val filteredCars = if (query.isNullOrEmpty()) {
            getSampleCars()
        } else {
            getSampleCars().filter { car ->
                car.name.contains(query, true) || car.mileage.contains(query, true)
            }
        }
        carAdapter.updateList(filteredCars)
    }

    private fun getSampleCars(): List<Car> {
        return listOf(
            Car(
                carId = "1",
                name = "BMW M8",
                year_of_make = "2023",
                mileage = "15 km/l",
                price = "250",
                image = "bmw_m8.jpg"
            ),
            Car(
                carId = "2",
                name = "Mercedes AMG",
                year_of_make = "2023",
                mileage = "12 km/l",
                price = "280",
                image = "mercedes_amg.jpg"
            ),
            Car(
                carId = "3",
                name = "Audi R8",
                year_of_make = "2023",
                mileage = "10 km/l",
                price = "300",
                image = "audi_r8.jpg"
            ),
            Car(
                carId = "4",
                name = "Porsche 911",
                year_of_make = "2023",
                mileage = "11 km/l",
                price = "320",
                image = "porsche_911.jpg"
            ),
            Car(
                carId = "5",
                name = "Lamborghini Huracan",
                year_of_make = "2023",
                mileage = "8 km/l",
                price = "450",
                image = "lamborghini_huracan.jpg"
            ),
            Car(
                carId = "6",
                name = "Ferrari F8",
                year_of_make = "2023",
                mileage = "9 km/l",
                price = "420",
                image = "ferrari_f8.jpg"
            ),
            Car(
                carId = "7",
                name = "Tesla Model S",
                year_of_make = "2023",
                mileage = "Electric",
                price = "200",
                image = "tesla_model_s.jpg"
            ),
            Car(
                carId = "8",
                name = "Range Rover",
                year_of_make = "2023",
                mileage = "14 km/l",
                price = "180",
                image = "range_rover.jpg"
            )
        )
    }
}