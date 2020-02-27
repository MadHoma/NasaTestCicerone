package com.nasa.test.cicerone.presentation.base

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.context.GlobalContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

abstract class BasePresenter<View : MvpView> : MvpPresenter<View>() {

    protected inline fun <reified  T : Any> inject(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null
    ) = lazy { GlobalContext.get().koin.get<T>(qualifier, parameters)}

    private val mCompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.clear()
    }

    fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    fun addDisposableFromView(d: Disposable) {
        addDisposable(d)
    }

}