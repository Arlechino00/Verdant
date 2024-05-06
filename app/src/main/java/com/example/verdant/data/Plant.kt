package com.example.verdant.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Plant(
    val id: Int,
    val name: String,
    val category: String,
    @StringRes val description: Int,
    @StringRes val use: Int,
    @DrawableRes val photo: Int
)