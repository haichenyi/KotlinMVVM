package com.haichenyi.mvvm.ui.frag

import android.os.Bundle
import androidx.navigation.Navigation
import com.haichenyi.mvvm.R
import com.haichenyi.mvvm.base.BaseFrag
import com.haichenyi.mvvm.databinding.FragSecondBinding
import com.haichenyi.mvvm.utils.LogUtil
import com.haichenyi.mvvm.utils.getViewModel
import com.haichenyi.mvvm.vm.FragSecondVm
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.frag_second.*

class FragSecond : BaseFrag<FragSecondBinding, FragSecondVm>(R.layout.frag_second) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    LogUtil.v(LogUtil.LOG_WZ, "FragSecond—created")
  }

  override fun initView(binding: FragSecondBinding, bundle: Bundle?) {
    super.initView(binding, bundle)
    tvSecond.setOnClickListener {
      Navigation.findNavController(it).navigate(R.id.action_fragSecond_to_fragThird)
    }
    btn.setOnClickListener {
      Navigation.findNavController(it).navigateUp()
    }
  }
}