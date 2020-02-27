package com.nasa.test.cicerone.presentation.ui.main.list

import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.presentation.base.BaseView

interface PhotoListView : BaseView {
    fun addItems(list: List<PhotoItem>)
}