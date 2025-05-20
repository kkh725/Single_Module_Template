package com.kkh.single.module.template.presentation.login

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.StateFlow

// 상태 모델: 로딩 상태 예시 필드 추가
data class LoginState(
    val loadingState: String = "idle"
){
    companion object {
        fun init() = LoginState(loadingState = "idle")
    }
}

// 액션(인텐트)
sealed class LoginAction {
    object ClickedButton : LoginAction()
}

class LoginReducer(initialState: LoginState) {
    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    // 상태 변화 함수 (Reducer 역할)
    fun reduce(event: LoginAction) {
        val oldState = _uiState.value
        when (event) {
            is LoginAction.ClickedButton -> {
                _uiState.value = oldState.copy(loadingState = "changed")
            }
        }
    }
}
