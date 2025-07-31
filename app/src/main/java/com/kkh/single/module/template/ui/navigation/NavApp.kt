package com.kkh.single.module.template.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.kkh.single.module.template.presentation.login.LoginViewModel

@Composable
fun App(){
    val navController = rememberNavController()
    val loginViewModel : LoginViewModel = hiltViewModel()
    val uiState = loginViewModel.uiState

    Scaffold { paddingValues ->
        AppNavGraph(
            modifier = Modifier.padding(paddingValues),
            navController
        )
    }
}