package com.haichenyi.mvvm.di.component

import androidx.databinding.ViewDataBinding
import com.haichenyi.mvvm.base.BaseFrag
import com.haichenyi.mvvm.base.BaseViewModel
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface FragComponent : AndroidInjector<BaseFrag<ViewDataBinding, BaseViewModel>> {
  @Subcomponent.Factory
  interface Factory : AndroidInjector.Factory<BaseFrag<ViewDataBinding, BaseViewModel>>
}