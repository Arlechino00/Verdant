package com.example.verdant.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Plant(
    val id: Int,
    val name: String,
    val category: String,
    @StringRes val poisonous: Int?,
    @StringRes val medicinal: Int?,
    @StringRes val description: Int?,
    @StringRes val warning: Int?,
    @DrawableRes val photo: Int
)