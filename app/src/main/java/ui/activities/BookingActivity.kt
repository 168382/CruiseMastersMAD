package com.example.cruisemastersmad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cruisemastersmad.ui.adapters.BookingAdapter
import com.example.cruisemastersmad.databinding.ActivityBookingBinding
import com.example.cruisemastersmad.models.Booking

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        val bookings = getSampleBookings()
        bookingAdapter = BookingAdapter(bookings)
        binding.bookingsRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@BookingActivity)
            adapter = bookingAdapter
        }
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun getSampleBookings(): List<Booking> {
        return listOf(
            Booking(1, 1, "BMW M8", "2024-01-15", "2024-01-20", 1500.0, "Confirmed"),
            Booking(2, 2, "Mercedes AMG", "2024-02-01", "2024-02-05", 1200.0, "Pending")
        )
    }
}