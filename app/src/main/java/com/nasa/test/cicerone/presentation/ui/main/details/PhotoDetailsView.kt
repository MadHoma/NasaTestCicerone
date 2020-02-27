package com.nasa.test.cicerone.presentation.ui.main.details

import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.presentation.base.BaseView

interface PhotoDetailsView : BaseView {
    fun setPhotoItem(item: PhotoItem)
}