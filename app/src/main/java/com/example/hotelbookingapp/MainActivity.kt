package com.example.hotelbookingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.ivMoscow).setOnClickListener { v: View? ->
            openHotels(
                "Москва"
            )
        }
        findViewById<View>(R.id.ivVoronezh).setOnClickListener { v: View? ->
            openHotels(
                "Воронеж"
            )
        }
        findViewById<View>(R.id.ivRostov).setOnClickListener { v: View? ->
            openHotels(
                "Ростов"
            )
        }
        findViewById<View>(R.id.ivKirov).setOnClickListener { v: View? ->
            openHotels(
                "Киров"
            )
        }
        findViewById<View>(R.id.ivMoscow2).setOnClickListener { v: View? ->
            openHotels(
                "Москва"
            )
        }
        findViewById<View>(R.id.ivNyurpe).setOnClickListener { v: View? ->
            openHotels(
                "Нюрпе"
            )
        }
    }

    private fun openHotels(city: String) {
        val intent = Intent(
            this,
            HotelListActivity::class.java
        )
        intent.putExtra("CITY", city)
        startActivity(intent)
    }
}