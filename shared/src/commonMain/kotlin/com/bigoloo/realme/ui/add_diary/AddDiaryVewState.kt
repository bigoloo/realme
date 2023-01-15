package com.bigoloo.realme.ui.add_diary

import com.bigoloo.realme.redux.State

data class AddDiaryVewState(
    val savingProgress: Boolean,
    val isSaved: Boolean = false
) : State