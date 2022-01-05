package com.example.medico.models

data class user(
    var _id:String,
    var name: String,
    var age :String,
    var email: String,
    var password: String,
    var phone: String,
    var address: String,
    var isAssistant: Boolean,
    var bloodType: String,
    var assistantName: String,
    var assistantPhone: String,
    var emergencyNum : String

)