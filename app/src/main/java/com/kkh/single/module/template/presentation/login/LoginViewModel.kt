package com.kkh.single.module.template.presentation.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.kkh.single.module.template.domain.repository.LoginRepository
import com.kkh.single.module.template.presentation.common.BaseMviViewModel
import com.kkh.single.module.template.presentation.common.SideEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    BaseMviViewModel<LoginState, LoginEvent, SideEffect>(
        reducer = LoginReducer(LoginState.init())
    ) {
    override suspend fun onEventAfterReduce(event: LoginEvent) {
        super.onEventAfterReduce(event)

        when (event) {
            is LoginEvent.ClickedButton -> {
                action()
            }
        }
    }

    fun action() {
        viewModelScope.launch {
            val res = loginRepository.setUserInfo("username")
            res.onSuccess { Log.d("TAG", "action: success") }
            res.onFailure { Log.d("TAG", "action: fail") }
        }
    }
}