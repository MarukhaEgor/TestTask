package com.example.testtask.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade

fun ImageView.loadGif(url: String?) {
    Glide.with(context)
        .asGif()
        .transition(withCrossFade())
        .load(url)
        .into(this)
}