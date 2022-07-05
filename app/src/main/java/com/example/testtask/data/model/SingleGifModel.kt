package com.example.testtask.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SingleGifModel(
    val images: GifDetail,
) : Parcelable