package com.haichenyi.mvvm.di.module

import androidx.lifecycle.ViewModelProvider
import com.haichenyi.mvvm.vm.VmFactory
import dagger.Binds
import dagger.Module

@Module
abstract class VmFactoryModule {
  @Binds
  internal abstract fun vmFactory(factory: VmFactory): ViewModelProvider.Factory
}