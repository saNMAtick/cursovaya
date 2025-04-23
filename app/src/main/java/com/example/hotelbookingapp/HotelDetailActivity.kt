package com.example.hotelbookingapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HotelDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        val hotel = intent.getSerializableExtra("HOTEL") as? Hotel ?: run {
            Toast.makeText(this, "Ошибка: данные об отеле не найдены", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val ivImage = findViewById<ImageView>(R.id.ivHotelImage)
        val tvName = findViewById<TextView>(R.id.tvHotelName)
        val tvPrice = findViewById<TextView>(R.id.tvPrice)
        val tvRating = findViewById<TextView>(R.id.tvRating)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val llServices = findViewById<LinearLayout>(R.id.llServices)

        ivImage.setImageResource(getImageResource(hotel.name))
        tvName.text = hotel.name
        tvPrice.text = "От ${hotel.price} руб."
        tvRating.text = "Рейтинг: ${hotel.rating}"
        tvDescription.text = hotel.description

        addService(llServices, "Wi-Fi")
        addService(llServices, "Бассейн")
        addService(llServices, "Спа")
        addService(llServices, "Ресторан")
    }

    private fun addService(layout: LinearLayout, service: String) {
        TextView(this).apply {
            text = "• $service"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layout.addView(this)
        }
    }

    private fun getImageResource(hotelName: String): Int {
        return R.drawable.ic_launcher_background
    }
}