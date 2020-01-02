package com.haichenyi.mvvm.ui.act

import android.os.Bundle
import androidx.navigation.findNavController
import com.haichenyi.mvvm.R
import com.haichenyi.mvvm.base.BaseAct
import com.haichenyi.mvvm.databinding.ActMainBinding

class MainAct : BaseAct<ActMainBinding>(R.layout.act_main) {
  override fun initDataBind(t: ActMainBinding, savedInstanceState: Bundle?) {
    super.initDataBind(t, savedInstanceState)

  }

  //onSupportNavigateUp()方法的重写，意味着Activity将它的 back键点击事件的委托出去，
  // 如果当前并非栈中顶部的Fragment, 那么点击back键，返回上一个Fragment。
  override fun onSupportNavigateUp() = findNavController(R.id.nav_graph_main).navigateUp()

}
