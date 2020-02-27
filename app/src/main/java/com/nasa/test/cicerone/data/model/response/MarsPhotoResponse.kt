package com.nasa.test.cicerone.data.model.response

import com.google.gson.annotations.SerializedName
import com.nasa.test.cicerone.data.model.common.PhotoItem
import java.util.*

data class MarsPhotoResponse(
    @SerializedName("photos")
    var photos: ArrayList<PhotoItem>?
)