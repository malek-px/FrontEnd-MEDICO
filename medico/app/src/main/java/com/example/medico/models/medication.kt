package com.example.medico.models

data class medication(
    var ref :String,
    var name:String,
    var description:String,
    var dose:String,
    var period:String,
    var quantity:String,
    var expDate:String,
    var image:String,
    var user:String
)
