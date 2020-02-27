package com.nasa.test.cicerone.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.nasa.test.cicerone.R


fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

fun <T : Any> T?.notNullOrEmpty(f: (it: T) -> Unit) {
    if (this != null && this != "" && this != "null") f(this)
}

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(this)
}

fun androidx.appcompat.widget.AppCompatImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}