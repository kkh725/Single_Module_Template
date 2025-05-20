package com.kkh.single.module.template.data.datasource.remote

import com.kkh.single.module.template.data.api.LoginApi
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val loginApi: LoginApi) {
    suspend fun fetchUserInfo(): Result<Unit> {
        return try {
            val response = loginApi.getUserInfo()
            if (response.isSuccessful) {
                Result.success(response.body() ?: Unit)
            } else {
                // 서버 응답은 왔지만 400/500 같은 에러일 경우
                Result.failure(Exception("Server Error: ${response.code()}"))
            }
        } catch (e: IOException) {
            // 네트워크 문제 (인터넷 끊김 등)
            Result.failure(Exception("Network Error", e))
        }
    }
}