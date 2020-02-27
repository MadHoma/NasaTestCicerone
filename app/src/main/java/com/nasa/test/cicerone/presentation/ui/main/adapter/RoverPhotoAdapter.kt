package com.nasa.test.cicerone.presentation.ui.main.adapter

import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.nasa.test.cicerone.R
import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.utils.setImageFromUrl

class RoverPhotoAdapter(layoutResId: Int, @Nullable data: List<PhotoItem>) :
    BaseQuickAdapter<PhotoItem, BaseViewHolder>(layoutResId, data) {
    override fun convert(helper: BaseViewHolder, item: PhotoItem) {
        helper.setText(R.id.tv_cameraName, item.camera?.fullName)
        helper.setText(R.id.tv_roverName, item.rover?.name)
        helper.getView<AppCompatImageView>(R.id.iv_roverImage)
        item.imgSrc?.let {
            helper.getView<AppCompatImageView>(R.id.iv_roverImage).setImageFromUrl(it)
        }
    }
}