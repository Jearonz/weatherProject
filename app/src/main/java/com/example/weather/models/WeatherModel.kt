package com.example.weather.models

data class WeatherModel(
    val city: String,
    val time: String,
    val condition: String,
    val currentTemperature : String,
    val maxTemperature: String,
    val minTemperature: String,
    val imageUrl: String,
    val hoursTemperature: String
    //val windSpeed: String
)