package com.example.hotelbookingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class HotelListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_list)

        val city = intent.getStringExtra("CITY")
        val tvCity = findViewById<TextView>(R.id.tvCity)
        tvCity.text = "Популярные отели в $city"

        val lvHotels = findViewById<ListView>(R.id.lvHotels)
        val hotels: List<Hotel> = getHotelsByCity(city)

        val adapter: HotelAdapter = HotelAdapter(this, hotels)
        lvHotels.adapter = adapter

        lvHotels.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                val intent = Intent(
                    this,
                    HotelDetailActivity::class.java
                )
                intent.putExtra("HOTEL", hotels[position])
                startActivity(intent)
            }
    }

    private fun getHotelsByCity(city: String?): List<Hotel> {
        val hotels: MutableList<Hotel> = ArrayList<Hotel>()
        if (city == "Москва") {
            hotels.add(Hotel("Отель Myconian", 7500, 4.8, "Описание..."))
            hotels.add(Hotel("Старый арбат", 7500, 4.5, "Описание..."))
            hotels.add(Hotel("Ambassador Hotel", 7500, 4.7, "Описание..."))
        } else if (city == "Воронеж") {
            hotels.add(Hotel("Воронеж Плаза", 5000, 4.3, "Описание..."))
            hotels.add(Hotel("Дегас", 4500, 4.6, "Описание..."))
            hotels.add(Hotel("Марриотт", 6000, 4.7, "Описание..."))
        } else if (city == "Ростов") {
            hotels.add(Hotel("Дон Плаза", 4000, 4.2, "Описание..."))
            hotels.add(Hotel("Амакс", 3500, 4.0, "Описание..."))
            hotels.add(Hotel("Radisson", 5500, 4.5, "Описание..."))
        }
        

        return hotels
    }
}