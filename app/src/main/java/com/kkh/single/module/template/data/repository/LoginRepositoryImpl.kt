package com.kkh.single.module.template.data.repository

import com.kkh.single.module.template.data.datasource.remote.RemoteDataSource
import com.kkh.single.module.template.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    LoginRepository {

    //business
    override suspend fun setUserInfo(userName: String): Result<Unit> {
        return remoteDataSource.fetchUserInfo()
    }
}