package com.haichenyi.mvvm.data.http

import androidx.lifecycle.LiveData
import com.haichenyi.mvvm.data.bean.AuthorBean
import com.haichenyi.mvvm.data.bean.BaseData
import com.haichenyi.mvvm.data.bean.UserBean
import com.haichenyi.mvvm.data.bean.VideoBean
import javax.inject.Inject

class HttpImpl @Inject constructor(private val httpApi: HttpApi) : HttpHelper {
  override fun getUsers(): LiveData<ApiResponse<BaseData<List<UserBean>>>> = httpApi.getUsers()

  override fun getUserById(userId: String): LiveData<ApiResponse<BaseData<UserBean>>> =
    httpApi.getUserById(userId)

  override fun getVideos(): LiveData<ApiResponse<BaseData<List<VideoBean>>>> = httpApi.getVideos()

  override fun getAuthor(): LiveData<ApiResponse<BaseData<AuthorBean>>> = httpApi.getAuthor()
}