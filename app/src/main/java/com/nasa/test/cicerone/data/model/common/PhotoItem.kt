package com.nasa.test.cicerone.data.model.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoItem(
    @SerializedName("id")
    var id: Long,
    @SerializedName("sol")
    val sol: Long,
    @SerializedName("camera")
    val camera: CameraFullItem?,
    @SerializedName("img_src")
    val imgSrc: String?,
    @SerializedName("earth_date")
    val earthDate: String?,
    @SerializedName("rover")
    val rover: RoverItem?
) : Parcelable