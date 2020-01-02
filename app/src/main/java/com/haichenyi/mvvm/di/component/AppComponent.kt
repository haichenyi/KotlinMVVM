package com.haichenyi.mvvm.di.component

import com.haichenyi.mvvm.base.BaseApp
import com.haichenyi.mvvm.data.DataCompat
import com.haichenyi.mvvm.di.module.*
import com.haichenyi.mvvm.di.module.ActModule
import com.haichenyi.mvvm.di.module.FragModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [AndroidSupportInjectionModule::class,
    AppModule::class,
    HttpModule::class,
    ActModule::class,
    FragModule::class,
    VmFactoryModule::class]
)
interface AppComponent : AndroidInjector<BaseApp> {
  @Component.Factory
  interface Factory : AndroidInjector.Factory<BaseApp>

  fun dataCompat(): DataCompat
}