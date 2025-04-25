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
            hotels.add(Hotel("Отель Myconian", 7500, 4.8, "Современный отель с роскошными номерами и высоким уровнем сервиса."))
            hotels.add(Hotel("Старый арбат", 7500, 4.5, "Комфортабельный отель в центре города с удобным доступом ко всем достопримечательностям."))
            hotels.add(Hotel("Ambassador Hotel", 7500, 4.7, "Известный отель с прекрасными видами и высококачественными услугами."))
        } else if (city == "Воронеж") {
            hotels.add(Hotel("Воронеж Плаза", 5000, 4.3, "Стильный отель с комфортными номерами и разнообразными удобствами."))
            hotels.add(Hotel("Дегас", 4500, 4.6, "Уютный отель с хорошим обслуживанием и приятной атмосферой."))
            hotels.add(Hotel("Марриотт", 6000, 4.7, "Премиум-отель с услугами высокого класса и отличным рестораном."))
        } else if (city == "Ростов") {
            hotels.add(Hotel("Дон Плаза", 4000, 4.2, "Отель рядом с рекой, предлагающий комфортные номера и хороший сервис."))
            hotels.add(Hotel("Амакс", 3500, 4.0, "Доступный отель с основными удобствами и позитивной атмосферой."))
            hotels.add(Hotel("Radisson", 5500, 4.5, "Отель с современным дизайном и высоким уровнем обслуживания."))
        } else if (city == "Киров") {
            hotels.add(Hotel("Отель Кировский", 4000, 4.2, "Уютный отель в центре города, предлагающий комфортные номера и завтрак."))
            hotels.add(Hotel("Гостиница Лотос", 3500, 4.0, "Доступный отель с основными удобствами и доброжелательным персоналом."))
            hotels.add(Hotel("Сити Отель", 5500, 4.5, "Современный отель с хорошими условиями для ночлега и бизнес-посетителей."))
        } else if (city == "Нюрпе") {
            hotels.add(Hotel("Гостиница Нюрпинская", 4000, 4.2, "Комфортный отель с домашней атмосферой и уютными номерами."))
            hotels.add(Hotel("Отель Сосновый Бор", 3500, 4.0, "Отель на природе с возможностью отдыха и релаксации."))
            hotels.add(Hotel("Гостиница Урал", 5500, 4.5, "Сервисный отель, предлагающий широкий спектр услуг для путешественников."))
        }

        

        return hotels
    }
}