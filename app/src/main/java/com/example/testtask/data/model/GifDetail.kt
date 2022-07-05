package com.example.testtask.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GifDetail(
    val original: Original,
) : Parcelable {
    @Parcelize
    data class Original(
        val url: String,
    ) : Parcelable
}
