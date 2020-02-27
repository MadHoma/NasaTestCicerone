package com.nasa.test.cicerone.presentation.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatActivity
import com.nasa.test.cicerone.R
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator

abstract class BaseActivity : MvpAppCompatActivity(), BaseView {

    private val mNavigatorHolder: NavigatorHolder by inject()
    private var mNavigator: SupportAppNavigator? = null

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    @IdRes
    protected open fun getContainerRes(): Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        initUtils()
        initUI()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        mNavigator?.let { mNavigatorHolder.setNavigator(it) }
    }

    override fun onPause() {
        super.onPause()
        mNavigator?.let { mNavigatorHolder.removeNavigator() }
    }

    @SuppressLint("ResourceType")
    protected fun initUtils(){
        if(getContainerRes() > 0){
            mNavigator = SupportAppNavigator(this, R.id.content_frame)
        }
    }
    protected abstract fun initUI()

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}