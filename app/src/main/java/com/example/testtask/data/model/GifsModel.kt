package com.example.testtask.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GifsModel(
    val data: List<SingleGifModel>,
) : Parcelable
