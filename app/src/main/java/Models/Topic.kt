
package com.example.mygrid.Models
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringvalue : Int,
    val availvalue : Int,
    @DrawableRes val imageres : Int
)
