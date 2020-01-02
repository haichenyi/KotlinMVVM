package com.haichenyi.mvvm.base

import com.haichenyi.mvvm.di.component.AppComponent
import com.haichenyi.mvvm.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApp : DaggerApplication() {

  companion object {
    lateinit var baseApp: BaseApp
  }

  val appComponent: AppComponent = DaggerAppComponent.factory().create(this) as AppComponent

  override
  fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

  override fun onCreate() {
    super.onCreate()
    baseApp = this
  }
}