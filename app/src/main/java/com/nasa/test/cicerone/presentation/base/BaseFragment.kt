package com.nasa.test.cicerone.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.arellomobile.mvp.MvpAppCompatFragment
import com.nasa.test.cicerone.utils.notNull
import com.nasa.test.cicerone.utils.view.ProgressHolder


abstract class BaseFragment : MvpAppCompatFragment() {

    private var baseActivity: BaseActivity? = null

    var progressHolder: ProgressHolder? = null

    @LayoutRes
    protected abstract fun getLayoutResource(): Int

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            baseActivity = context as BaseActivity?
        } catch (e: ClassCastException) {
            throw IllegalArgumentException("BaseFragment should be in BaseActivity")
        }
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                baseActivity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutResource(), container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    fun showMessage(message: String) {
        baseActivity?.showMessage(message)
    }

    abstract fun initUI()

    fun showProgress() {
        progressHolder.notNull { holder ->
            holder.show()
        }
    }

    fun hideProgress() {
        progressHolder.notNull { holder ->
            holder.hide()
        }
    }

}