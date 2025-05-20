package com.kkh.single.module.template.domain.repository

interface LoginRepository {
    suspend fun setUserInfo(userName: String): Result<Unit>
}