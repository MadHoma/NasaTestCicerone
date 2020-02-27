package com.nasa.test.cicerone.data.model.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CameraTinyItem(
    @SerializedName("name")
    private var name: String,
    @SerializedName("full_name")
    val fullName: String
) : Parcelable