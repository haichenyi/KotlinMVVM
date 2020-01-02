package com.haichenyi.mvvm.ui.frag

import android.os.Bundle
import androidx.navigation.Navigation
import com.haichenyi.mvvm.R
import com.haichenyi.mvvm.base.BaseFrag
import com.haichenyi.mvvm.databinding.FragFirstBinding
import com.haichenyi.mvvm.utils.LogUtil
import com.haichenyi.mvvm.vm.FragFirstVm
import kotlinx.android.synthetic.main.frag_first.*

class FragFirst : BaseFrag<FragFirstBinding, FragFirstVm>(R.layout.frag_first) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    LogUtil.v(LogUtil.LOG_WZ, "FragFirst—created")
  }

  override fun initView(binding: FragFirstBinding, bundle: Bundle?) {
    super.initView(binding, bundle)
    tvFirst.setOnClickListener {
      Navigation.findNavController(it).navigate(R.id.action_fragFirst_to_fragSecond)
    }
    vm.test()
  }

}