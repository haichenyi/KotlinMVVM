package com.haichenyi.mvvm.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.haichenyi.mvvm.utils.getViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import java.lang.reflect.ParameterizedType
import javax.inject.Inject

open class BaseFrag<T : ViewDataBinding, VM : BaseViewModel>(@LayoutRes layoutId: Int) :
  Fragment(layoutId),
  HasAndroidInjector {
  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>
  @Inject
  lateinit var vmFactory: ViewModelProvider.Factory
  lateinit var vm: VM

  private var initialized = false
  private lateinit var rootView: View
  override fun androidInjector(): AndroidInjector<Any> = androidInjector
  override fun onAttach(context: Context) {
    AndroidSupportInjection.inject(this)
    super.onAttach(context)
  }

  final override fun onResume() {
    super.onResume()
    if (initialized.not()) {
      initialized = true
      onLazyInitView(arguments)
    }
  }

  final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    rootView = view
  }

  @Suppress("UNCHECKED_CAST")
  private fun onLazyInitView(bundle: Bundle?) {
    val type = javaClass.genericSuperclass as ParameterizedType
    val clazz: Class<VM> = type.actualTypeArguments[1] as Class<VM>
    vm = ViewModelProvider(this, vmFactory)[clazz]
    if (this::rootView.isInitialized) {
      vm.onCreated(viewLifecycleOwner)
      DataBindingUtil.bind<T>(rootView)?.let {
        initView(it, bundle)
      }
    }
  }

  protected open fun initView(binding: T, bundle: Bundle?): Unit = Unit

}