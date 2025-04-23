package com.example.hotelbookingapp


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView


class HotelAdapter(context: Context?, hotels: List<Hotel?>?) :
    ArrayAdapter<Hotel?>(context!!, 0, hotels!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val hotel = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.item_hotel, parent, false)
        }

        val tvName = convertView!!.findViewById<TextView>(R.id.tvHotelName)
        val tvPrice = convertView.findViewById<TextView>(R.id.tvPrice)
        val tvRating = convertView.findViewById<TextView>(R.id.tvRating)

        if (hotel != null) {
            tvName.setText(hotel.name)
        }
        tvPrice.text = ("От " + hotel?.price) + " руб."
        tvRating.text = "Рейтинг: " + hotel?.rating

        return convertView
    }
}