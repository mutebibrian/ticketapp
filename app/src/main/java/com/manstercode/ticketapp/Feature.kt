package com.manstercode.ticketapp

data class Feature(
    val name: String,
    val iconResId: Int,
    val activityClass: Class<*>
)