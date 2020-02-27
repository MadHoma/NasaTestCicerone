package com.nasa.test.cicerone.data.model.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CameraFullItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rover_id")
    val roverId: Int,
    @SerializedName("full_name")
    val fullName: String? = null
) : Parcelable