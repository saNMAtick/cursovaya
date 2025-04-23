// Hotel.java
package com.example.hotelbookingapp

import java.io.Serializable

class Hotel(

    var name: String, var price: Int, var rating: Double, var description: String
) :
    Serializable