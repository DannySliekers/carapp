package com.example.carapp.network

data class Car(
    val id: String, val model: String, val carType: CarType, val transmission: CarTransmission, val carSize: CarSize, val location: String
)
