package com.haichenyi.mvvm.di.module

import com.haichenyi.mvvm.data.DataCompat
import com.haichenyi.mvvm.data.http.HttpHelper
import com.haichenyi.mvvm.data.http.HttpImpl
import dagger.Module
import dagger.Provides
import java.security.cert.X509Certificate
import javax.inject.Singleton
import javax.net.ssl.X509TrustManager

@Module
class AppModule {

  @Provides
  @Singleton
  internal fun httpHelper(httpImpl: HttpImpl): HttpHelper = httpImpl

  @Provides
  @Singleton
  internal fun dataCompat(httpHelper: HttpHelper): DataCompat = DataCompat(httpHelper)

}