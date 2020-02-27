package com.nasa.test.cicerone.presentation.ui.main.list

import com.arellomobile.mvp.InjectViewState
import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.data.network.CommonService
import com.nasa.test.cicerone.presentation.base.BasePresenter
import com.nasa.test.cicerone.presentation.navigator.Screens
import com.nasa.test.cicerone.utils.notNull
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import timber.log.Timber


@InjectViewState
class PhotoListPresenter : BasePresenter<PhotoListView>() {

    private val mCommonService: CommonService by inject()
    private val mRouter: Router by inject()


    fun loadData() {
        addDisposable(mCommonService.getMarsRoversPhotos("curiosity", 1000, "fhaz")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.notNull { r ->
                    r.photos?.let { viewState.addItems(it) }
                }
            }, { e ->
                Timber.e(e)
                viewState.showMessage(e.localizedMessage)
            }))

    }

    fun openDetailsScreen(item: PhotoItem) {
        mRouter.navigateTo(Screens.PhotoDetailsScreen(item))
    }

}