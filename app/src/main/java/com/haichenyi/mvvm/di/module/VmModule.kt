package com.haichenyi.mvvm.di.module

import androidx.lifecycle.ViewModel
import com.haichenyi.mvvm.di.scope.VmKey
import com.haichenyi.mvvm.vm.FragFirstVm
import com.haichenyi.mvvm.vm.FragSecondVm
import com.haichenyi.mvvm.vm.FragThirdVm
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragFirstModule {
  @Binds
  @IntoMap
  @VmKey(FragFirstVm::class)
  abstract fun getViewModel(fragFirstVm: FragFirstVm): ViewModel
}

@Module
abstract class FragThirdModule {
  @Binds
  @IntoMap
  @VmKey(FragThirdVm::class)
  abstract fun getViewModel(fragThirdVm: FragThirdVm): ViewModel
}

@Module
abstract class FragSecondModule {
  @Binds
  @IntoMap
  @VmKey(FragSecondVm::class)
  abstract fun getViewModel(FragSecondVm: FragSecondVm): ViewModel
}

