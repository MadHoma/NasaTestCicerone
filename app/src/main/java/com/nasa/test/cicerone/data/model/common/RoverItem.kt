package com.nasa.test.cicerone.data.model.common

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.nasa.test.cicerone.data.model.common.CameraTinyItem
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class RoverItem(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("landing_date")
    val landingDate: String?,
    @SerializedName("launch_date")
    val launchDate: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("max_sol")
    val maxSol: Long,
    @SerializedName("max_date")
    val maxDate: String?,
    @SerializedName("total_photos")
    val totalPhotos: Long,
    @SerializedName("cameras")
    val cameras: ArrayList<CameraTinyItem>?
) : Parcelable