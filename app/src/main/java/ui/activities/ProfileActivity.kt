package com.example.cruisemastersmad.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cruisemastersmad.databinding.ActivityProfileBinding
import com.example.cruisemastersmad.ui.adapters.BookingAdapter
import com.example.cruisemastersmad.ui.adapters.PurchaseAdapter
import com.example.cruisemastersmad.ui.models.Booking
import com.example.cruisemastersmad.ui.models.Purchase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var purchaseAdapter: PurchaseAdapter
    private lateinit var bookingAdapter: BookingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapters()
        loadUserData()
        loadPurchases()
        loadBookings()
        setupToolbar()
    }

    private fun setupAdapters() {
        purchaseAdapter = PurchaseAdapter()
        bookingAdapter = BookingAdapter()

        binding.recyclerViewPurchases.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity)
            adapter = purchaseAdapter
        }

        binding.recyclerViewBookings.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity)
            adapter = bookingAdapter
        }
    }

    private fun loadUserData() {
        val sharedPref = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val userName = sharedPref.getString("user_name", "User")
        val userEmail = sharedPref.getString("user_email", "user@example.com")

        binding.tvUserName.text = userName
        binding.tvUserEmail.text = userEmail
    }

    private fun loadPurchases() {
        val sharedPref = getSharedPreferences("user_purchases", MODE_PRIVATE)
        val purchasesSet = sharedPref.getStringSet("purchases", setOf()) ?: setOf()

        val purchases = purchasesSet.map { purchaseData ->
            val parts = purchaseData.split("|")
            val date = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(parts[2].toLong()))
            Purchase(
                id = parts[0].toInt(),
                carName = parts[1],
                date = date
            )
        }.reversed() // Show latest first

        purchaseAdapter.submitList(purchases)

        if (purchases.isEmpty()) {
            binding.tvNoPurchases.visibility = android.view.View.VISIBLE
            binding.recyclerViewPurchases.visibility = android.view.View.GONE
        } else {
            binding.tvNoPurchases.visibility = android.view.View.GONE
            binding.recyclerViewPurchases.visibility = android.view.View.VISIBLE
        }
    }

    private fun loadBookings() {
        val sharedPref = getSharedPreferences("user_bookings", MODE_PRIVATE)
        val bookingsSet = sharedPref.getStringSet("bookings", setOf()) ?: setOf()

        val bookings = bookingsSet.map { bookingData ->
            val parts = bookingData.split("|")
            val date = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(Date(parts[2].toLong()))
            Booking(
                id = parts[0].toInt(),
                carName = parts[1],
                date = date
            )
        }.reversed() // Show latest first

        bookingAdapter.submitList(bookings)

        if (bookings.isEmpty()) {
            binding.tvNoBookings.visibility = android.view.View.VISIBLE
            binding.recyclerViewBookings.visibility = android.view.View.GONE
        } else {
            binding.tvNoBookings.visibility = android.view.View.GONE
            binding.recyclerViewBookings.visibility = android.view.View.VISIBLE
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}