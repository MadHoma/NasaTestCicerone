package com.nasa.test.cicerone.di

import android.app.Application
import com.nasa.test.cicerone.di.modules.networkModule
import com.nasa.test.cicerone.presentation.base.BasePresenter
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

object DI {

    inline fun <reified  T : Any> BasePresenter<*>.inject(
        qualifier: Qualifier? = null,
        noinline parameters: ParametersDefinition? = null
    ) = lazy { GlobalContext.get().koin.get<T>(qualifier, parameters)}

    fun init(app: Application) {
        val allModules: List<Module> = listOf(
            networkModule,
            navigationModule,
            appModule
        )

        startKoin {
            AndroidLogger()
            androidContext(app)
            modules(allModules)
        }
    }
}

//==============================================================================================
// *** Features ***
//==============================================================================================

val appModule = module {

}

//==============================================================================================
// *** Navigation ***
//==============================================================================================

val navigationModule = module {
    single { Cicerone.create<Router>(Router()) }
    single<Router> { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }
}
