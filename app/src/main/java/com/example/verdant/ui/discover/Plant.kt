package com.example.verdant.ui.discover

import android.graphics.drawable.Drawable

data class Plant(
    val id: Long,
    val common_name: String,
    val poisonous: String,
    val medicinal: String,
    val region: String,
    val image: Drawable
)
