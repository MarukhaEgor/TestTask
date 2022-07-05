package com.example.testtask.ext

import android.content.Context

fun Context.dpToPx(dp: Int): Int {
    return (dp.toFloat() * this.resources.displayMetrics.density).toInt()
}