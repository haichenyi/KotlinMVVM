package com.haichenyi.mvvm.di.module

import com.haichenyi.mvvm.di.component.FragComponent
import com.haichenyi.mvvm.di.scope.FragScoped
import com.haichenyi.mvvm.ui.frag.FragFirst
import com.haichenyi.mvvm.ui.frag.FragSecond
import com.haichenyi.mvvm.ui.frag.FragThird
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [FragComponent::class])
internal abstract class FragModule {

  @FragScoped
  @ContributesAndroidInjector(modules = [FragFirstModule::class])
  internal abstract fun fragFirst(): FragFirst

  @FragScoped
  @ContributesAndroidInjector(modules = [FragSecondModule::class])
  internal abstract fun fragSecond(): FragSecond

  @FragScoped
  @ContributesAndroidInjector(modules = [FragThirdModule::class])
  internal abstract fun fragThird(): FragThird
}