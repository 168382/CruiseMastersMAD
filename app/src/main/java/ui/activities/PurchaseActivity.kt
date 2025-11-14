package com.example.cruisemastersmad.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ui.adapters.PurchaseAdapter
import com.example.cruisemastersmad.databinding.ActivityPurchaseBinding
import ui.models.Purchase
import com.example.cruisemastersmad.ui.adapters.PurchaseAdapter
import ui.models.Purchase


class PurchaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPurchaseBinding
    private lateinit var purchaseAdapter: PurchaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPurchaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        val purchases = getSamplePurchases()
        purchaseAdapter = PurchaseAdapter(purchases)
        binding.purchasesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@PurchaseActivity)
            adapter = PurchaseAdapter
        }
    }

    private fun setupClickListeners() {
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    private fun getSamplePurchases(): List<Purchase> {
        return listOf(
            Purchase(1, "BMW M8", 1500.0, "2024-01-15", "Completed"),
            Purchase(2, "Mercedes AMG", 1200.0, "2024-02-01", "Processing")
        )
    }
}