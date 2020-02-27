package com.nasa.test.cicerone.di.modules

import android.content.Context
import com.nasa.test.cicerone.data.local.Constants
import com.nasa.test.cicerone.data.network.CommonService
import com.nasa.test.cicerone.di.modules.Constants.CONNECTION_TIMEOUT
import com.nasa.test.cicerone.di.modules.Constants.NETWORK_CACHE
import com.nasa.test.cicerone.di.modules.Constants.Q_NETWORK_CACHE
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private object Constants {

    const val CONNECTION_TIMEOUT = 30L
    const val NETWORK_CACHE = "network_cache"
    // Qualifier field
    val Q_NETWORK_CACHE = named(NETWORK_CACHE)
}

val networkModule = module {

    single { get<Retrofit>().create(CommonService::class.java) }

    //Init Okhttp & Retrofit
    single(Q_NETWORK_CACHE) { androidApplication().getDir(NETWORK_CACHE, Context.MODE_PRIVATE) }

    single {
        val cacheSize = 20 * 1024 * 1024 // 20 MiB
        Cache(get(Q_NETWORK_CACHE), cacheSize.toLong())
    }

    single {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor { chain ->
            val original = chain.request()

            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", Constants.Keys.NASA_API_KEY)
                .build()
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val okHttp = builder
            .cache(get<Cache>())
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(
                httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttp)
            .baseUrl(Constants.URL.BASE_SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        retrofit
    }

}