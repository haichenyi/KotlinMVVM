package com.haichenyi.mvvm.data.http

import androidx.lifecycle.LiveData
import com.haichenyi.mvvm.data.bean.AuthorBean
import com.haichenyi.mvvm.data.bean.BaseData
import com.haichenyi.mvvm.data.bean.UserBean
import com.haichenyi.mvvm.data.bean.VideoBean
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface HttpApi {
  @GET(HttpProtocol.HTTP_GET_USERS)
  fun getUsers(): LiveData<ApiResponse<BaseData<List<UserBean>>>>

  @FormUrlEncoded
  @GET(HttpProtocol.HTTP_GET_USER_BY_ID + "{userId}")
  fun getUserById(@Path("userId") userId: String): LiveData<ApiResponse<BaseData<UserBean>>>

  @GET(HttpProtocol.HTTP_GET_VIDEOS)
  fun getVideos(): LiveData<ApiResponse<BaseData<List<VideoBean>>>>

  @GET(HttpProtocol.HTTP_GET_AUTHOR)
  fun getAuthor(): LiveData<ApiResponse<BaseData<AuthorBean>>>
}