package com.haichenyi.mvvm.di.component

import androidx.databinding.ViewDataBinding
import com.haichenyi.mvvm.base.BaseAct
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface ActComponent : AndroidInjector<BaseAct<ViewDataBinding>> {
  @Subcomponent.Factory
  interface Factory : AndroidInjector.Factory<BaseAct<ViewDataBinding>>
}