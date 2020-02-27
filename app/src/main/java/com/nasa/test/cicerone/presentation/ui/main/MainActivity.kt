package com.nasa.test.cicerone.presentation.ui.main

import com.arellomobile.mvp.presenter.InjectPresenter
import com.nasa.test.cicerone.R
import com.nasa.test.cicerone.presentation.base.BaseActivity
import com.nasa.test.presentation.ui.main.MainView

class MainActivity : BaseActivity(), MainView {


    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun getContainerRes(): Int = R.id.content_frame
    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initUI() {
        mPresenter.showFragment()
    }

}