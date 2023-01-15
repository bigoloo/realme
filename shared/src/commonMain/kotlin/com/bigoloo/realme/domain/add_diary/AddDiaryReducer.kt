package com.bigoloo.realme.domain.add_diary

import com.bigoloo.realme.redux.Reducer
import com.bigoloo.realme.ui.add_diary.AddDiaryVewState

class AddDiaryReducer : Reducer<AddDiaryVewState, AddDiaryAction> {
    override fun reduce(currentState: AddDiaryVewState, action: AddDiaryAction): AddDiaryVewState {
        return when (action) {
            AddDiaryAction.SavedDiaryAction -> {
                currentState.copy(
                    isSaved = true,
                    savingProgress = false
                )
            }
            AddDiaryAction.SavingDiaryAction -> {
                currentState.copy(savingProgress = true, isSaved = false)
            }
            else -> currentState
        }
    }
}