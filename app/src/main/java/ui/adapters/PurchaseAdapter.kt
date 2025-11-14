package com.example.cruisemastersmad.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cruisemastersmad.R
import ui.models.Purchase

class PurchaseAdapter(private val purchases: List<Purchase>) :
    RecyclerView.Adapter<PurchaseAdapter.PurchaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_purchase, parent, false)
        return PurchaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: PurchaseViewHolder, position: Int) {
        holder.bind(purchases[position])
    }

    override fun getItemCount() = purchases.size

    class PurchaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carName: TextView = itemView.findViewById(R.id.purchaseCarName)
        private val amount: TextView = itemView.findViewById(R.id.purchaseAmount)
        private val date: TextView = itemView.findViewById(R.id.purchaseDate)
        private val status: TextView = itemView.findViewById(R.id.purchaseStatus)

        fun bind(purchase: Purchase) {
            carName.text = purchase.carName
            amount.text = "$${purchase.price}"
            date.text = purchase.purchaseDate
            status.text = purchase.status


        }
    }
}