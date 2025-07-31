package com.kkh.single.module.template.presentation.login

import com.kkh.single.module.template.presentation.common.Reducer
import com.kkh.single.module.template.presentation.common.SideEffect
import com.kkh.single.module.template.presentation.common.UiEvent
import com.kkh.single.module.template.presentation.common.UiState
import javax.inject.Inject

// 상태 모델: 로딩 상태 예시 필드 추가
data class LoginState(
    val loadingState: String = "idle"
) : UiState {
    companion object {
        fun init() = LoginState(loadingState = "idle")
    }
}

// 액션(인텐트)
sealed class LoginEvent : UiEvent {
    object ClickedButton : LoginEvent()
}

sealed class MainEffect : SideEffect {
}

class LoginReducer @Inject constructor(state: LoginState) :
    Reducer<LoginState, LoginEvent, SideEffect>(state) {
    override suspend fun reduce(oldState: LoginState, event: LoginEvent) {
        when (event) {
            is LoginEvent.ClickedButton -> {}
        }
    }
}
