package com.nasa.test.cicerone.presentation.navigator

import android.content.Context
import android.content.Intent
import com.nasa.test.cicerone.data.model.common.PhotoItem
import com.nasa.test.cicerone.presentation.ui.main.MainActivity
import com.nasa.test.cicerone.presentation.ui.main.details.PhotoDetailsFragment
import com.nasa.test.cicerone.presentation.ui.main.list.PhotoListFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class PhotoListScreen: SupportAppScreen(){
        override fun getFragment() = PhotoListFragment.newInstance()
    }

    class PhotoDetailsScreen(private val item: PhotoItem): SupportAppScreen(){
        override fun getFragment() = PhotoDetailsFragment.newInstance(item)
    }

    class MainScreen: SupportAppScreen(){
        override fun getActivityIntent(context: Context?): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}