package com.haichenyi.mvvm.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
fun <T> Fragment.getViewModel(clazz: Class<T>): T {
  return ViewModelProvider(this)[clazz as Class<ViewModel>] as T
}