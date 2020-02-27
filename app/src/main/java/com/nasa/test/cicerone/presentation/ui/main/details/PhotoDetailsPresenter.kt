package com.nasa.test.cicerone.presentation.ui.main.details

import android.os.Bundle
import com.arellomobile.mvp.InjectViewState
import com.nasa.test.cicerone.data.local.Constants.Arguments.PHOTO_ITEM
import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.presentation.base.BasePresenter
import com.nasa.test.cicerone.presentation.navigator.Screens
import com.nasa.test.cicerone.utils.notNull
import ru.terrakok.cicerone.Router

@InjectViewState
class PhotoDetailsPresenter : BasePresenter<PhotoDetailsView>() {


    private val mRouter: Router by inject()

    fun checkBundle(arg: Bundle?) {
        arg.notNull { a ->
            if (a.containsKey(PHOTO_ITEM)) {
                viewState.setPhotoItem(a.getParcelable(PHOTO_ITEM) as PhotoItem)
            }
        }
    }

    fun openMain() {
        mRouter.navigateTo(Screens.MainScreen())
    }

}