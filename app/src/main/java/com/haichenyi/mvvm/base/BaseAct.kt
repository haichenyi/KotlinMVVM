package com.haichenyi.mvvm.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.haichenyi.mvvm.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseAct<T : ViewDataBinding>(@LayoutRes layoutId: Int) : AppCompatActivity(
  layoutId
), HasAndroidInjector {
  protected var isLight = true
  protected var statusColor = Color.TRANSPARENT
  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> = androidInjector

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    initStatus()
    val rootView = findViewById<View?>(R.id.root)
    if (rootView != null) {
      DataBindingUtil.bind<T>(rootView)?.let {
        initDataBind(it, savedInstanceState)
      }
    }
  }

  private fun initStatus() {
    var visibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    if (isLight) {
      if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {
        visibility = visibility.or(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
      }
    }
    window.decorView.systemUiVisibility = visibility
    window.statusBarColor = statusColor
  }

  protected open fun initDataBind(
    t: T,
    savedInstanceState: Bundle?
  ): Unit = Unit
}