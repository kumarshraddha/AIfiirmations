package com.shraddha.aifiirmations

import androidx.annotation.DrawableRes

data class Affirmation(
    val id: Int,
    val text: String,
    @param:DrawableRes val imageResourceId: Int,
)