package com.nasa.test.cicerone.presentation.ui.main

import com.arellomobile.mvp.InjectViewState
import com.nasa.test.cicerone.presentation.base.BasePresenter
import com.nasa.test.cicerone.presentation.navigator.Screens
import com.nasa.test.presentation.ui.main.MainView
import ru.terrakok.cicerone.Router

@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    private val mRoute: Router by inject()


    fun showFragment() {
        mRoute.newRootScreen(Screens.PhotoListScreen())
    }

}