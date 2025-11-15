package com.example.cruisemastersmad.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cruisemastersmad.R
import ui.models.Booking

class BookingAdapter : RecyclerView.Adapter<BookingAdapter.BookingViewHolder>() {

    private val bookings = mutableListOf<Booking>()

    fun submitList(newList: List<Booking>) {
        bookings.clear()
        bookings.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_booking, parent, false)
        return BookingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        holder.bind(bookings[position])
    }

    override fun getItemCount() = bookings.size

    class BookingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val carName: TextView = itemView.findViewById(R.id.bookingCarName)
        private val period: TextView = itemView.findViewById(R.id.bookingPeriod)

        fun bind(booking: Booking) {
            carName.text = booking.vehicleName
            period.text = "${booking.pickupDate} → ${booking.returnDate}"
        }
    }
}
