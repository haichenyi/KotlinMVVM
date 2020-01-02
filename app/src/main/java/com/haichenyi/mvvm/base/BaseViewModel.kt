package com.haichenyi.mvvm.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.haichenyi.mvvm.data.DataCompat

open class BaseViewModel : ViewModel() {
  protected lateinit var dataCompat: DataCompat
  protected lateinit var owner: LifecycleOwner
  /**
   * 初始化需要用到的数据
   */
  fun onCreated(owner: LifecycleOwner) {
    dataCompat = BaseApp.baseApp.appComponent.dataCompat()
    this.owner = owner
  }

  override fun onCleared() {
    super.onCleared()
  }

  /**
   * 判断dataCompat有没有初始化
   */
  protected fun isDataCompatInit(): Boolean = this::dataCompat.isInitialized
}