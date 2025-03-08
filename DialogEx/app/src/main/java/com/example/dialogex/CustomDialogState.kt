package com.example.dialogex

data class CustomAlertDialogState(
    val title: String = "",
    val description: String = "",
    val onClickCancel: () -> Unit = {},
    val onClickConfirm: () -> Unit = {}
)

data class CustomBottomSheetDialogState(
    val title: String = "",
    val description: String = "",
    val onClickCancel: () -> Unit = {},
    val onClickConfirm: () -> Unit = {}
)
