package com.nasa.test.cicerone.presentation.ui.main.details

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.nasa.test.cicerone.R
import com.nasa.test.cicerone.data.local.Constants.Arguments.PHOTO_ITEM
import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.presentation.base.BaseFragment
import com.nasa.test.cicerone.utils.setImageFromUrl
import kotlinx.android.synthetic.main.fragment_details.*

class PhotoDetailsFragment : BaseFragment(), PhotoDetailsView {

    companion object {
        fun newInstance(item: PhotoItem): PhotoDetailsFragment {
            val fragment = PhotoDetailsFragment()
            val args = Bundle()
            args.putParcelable(PHOTO_ITEM, item)
            fragment.arguments = args
            return fragment
        }
    }

    @InjectPresenter
    lateinit var mPresenter: PhotoDetailsPresenter

    override fun getLayoutResource(): Int = R.layout.fragment_details

    override fun initUI() {
        mPresenter.checkBundle(arguments)
        iv_roverImage.setOnClickListener { mPresenter.openMain() }
    }

    override fun setPhotoItem(item: PhotoItem) {
        tv_cameraName.text = item.camera?.fullName
        tv_roverName.text = item.rover?.name
        context?.let {
            item.imgSrc?.let { iv_roverImage.setImageFromUrl(it) }
        }
    }


}