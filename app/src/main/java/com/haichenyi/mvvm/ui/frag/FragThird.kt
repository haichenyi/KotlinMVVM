package com.haichenyi.mvvm.ui.frag

import android.os.Bundle
import androidx.navigation.Navigation
import com.haichenyi.mvvm.R
import com.haichenyi.mvvm.base.BaseFrag
import com.haichenyi.mvvm.databinding.FragThirdBinding
import com.haichenyi.mvvm.utils.LogUtil
import com.haichenyi.mvvm.vm.FragThirdVm
import kotlinx.android.synthetic.main.frag_third.*

class FragThird : BaseFrag<FragThirdBinding, FragThirdVm>(R.layout.frag_third) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    LogUtil.v(LogUtil.LOG_WZ, "FragThird—created")
  }

  override fun initView(binding: FragThirdBinding, bundle: Bundle?) {
    super.initView(binding, bundle)
    tvThird.setOnClickListener {
      Navigation.findNavController(it).navigate(R.id.action_fragThird_to_fragFirst)
    }
    btn.setOnClickListener {
      Navigation.findNavController(it).navigateUp()
    }

  }
}