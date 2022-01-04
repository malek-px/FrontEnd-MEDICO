package com.example.medico


import androidx.annotation.DrawableRes

const val PICTURE = "PICTURE"
const val NAME = "NAME"
const val DESCRIPTION = "DESCRIPTION"
const val FREQUENCY = "FREQUENCY"

data class Medication
    (
    @DrawableRes
    val medPic: Int,

    val medName: String,

    val medDesc: String,

    val medFreq:String
)