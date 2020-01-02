package com.haichenyi.mvvm.data.http

import androidx.lifecycle.LiveData
import com.haichenyi.mvvm.data.bean.AuthorBean
import com.haichenyi.mvvm.data.bean.BaseData
import com.haichenyi.mvvm.data.bean.UserBean
import com.haichenyi.mvvm.data.bean.VideoBean
import retrofit2.http.Path

interface HttpHelper {
  fun getUsers(): LiveData<ApiResponse<BaseData<List<UserBean>>>>

  fun getUserById(@Path("userId") userId: String): LiveData<ApiResponse<BaseData<UserBean>>>

  fun getVideos(): LiveData<ApiResponse<BaseData<List<VideoBean>>>>

  fun getAuthor(): LiveData<ApiResponse<BaseData<AuthorBean>>>
}