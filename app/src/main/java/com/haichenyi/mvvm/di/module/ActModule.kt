package com.haichenyi.mvvm.di.module

import com.haichenyi.mvvm.di.component.ActComponent
import com.haichenyi.mvvm.di.scope.ActScoped
import com.haichenyi.mvvm.ui.act.MainAct
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [ActComponent::class])
internal abstract class ActModule {

  @ActScoped
  @ContributesAndroidInjector
  internal abstract fun mainAct(): MainAct
}