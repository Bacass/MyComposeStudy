package com.example.dialogex

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val customAlertDialogState: MutableState<CustomAlertDialogState> =
        mutableStateOf<CustomAlertDialogState>(
            CustomAlertDialogState()
        )
    val showDialog = mutableStateOf(false)

    val customBottomSheetDialogState: MutableState<CustomBottomSheetDialogState> =
        mutableStateOf<CustomBottomSheetDialogState>(
            CustomBottomSheetDialogState()
        )
    val showBottomSheetDialog = mutableStateOf(false)

    fun showCustomAlertDialog() {
        customAlertDialogState.value = CustomAlertDialogState(
            title = "타이틀 타이틀 타이틀",
            description = "description, description, description",
            onClickCancel = {
                resetDialogState()
            },
            onClickConfirm = {
                resetDialogState()
            }
        )
        showDialog.value = true
    }

    fun resetDialogState() {
        customAlertDialogState.value = CustomAlertDialogState()
        showDialog.value = false
    }

    fun showBottomSheetDialog() {
        customBottomSheetDialogState.value = CustomBottomSheetDialogState(
            title = "국기 이모지",
            description = "나라별 국기 이모지를 확인해보세요.",
            onClickCancel = {
                resetBottomSheetDialogState()
            },
            onClickConfirm = {
                resetBottomSheetDialogState()
            }
        )
        showBottomSheetDialog.value = true
    }

    fun resetBottomSheetDialogState() {
        customBottomSheetDialogState.value = CustomBottomSheetDialogState()
        showBottomSheetDialog.value = false
    }
}