package com.example.philosophycentre.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    @StringRes val textResourceId: Int,
   // @StringRes val attributionResourceId: Int
    val attributionResource: String
) {

}