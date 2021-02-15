package com.example.akademiaandroida.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}