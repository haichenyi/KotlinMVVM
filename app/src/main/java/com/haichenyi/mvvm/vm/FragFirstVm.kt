package com.haichenyi.mvvm.vm

import com.haichenyi.mvvm.base.BaseViewModel
import com.haichenyi.mvvm.data.http.httpObserver
import javax.inject.Inject

class FragFirstVm @Inject constructor() : BaseViewModel() {

  fun test() {
    dataCompat.getAuthor().observe(owner, httpObserver {
      onSuccess {

      }
      onFailed { code, msg ->

      }
    })
  }
}