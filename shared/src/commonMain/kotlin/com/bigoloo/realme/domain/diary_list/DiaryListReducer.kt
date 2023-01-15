package com.bigoloo.realme.domain.diary_list

import com.bigoloo.realme.redux.Reducer
import com.bigoloo.realme.ui.diary_list.DiaryListViewState

class DiaryListReducer : Reducer<DiaryListViewState, DiaryListAction> {
    override fun reduce(
        currentState: DiaryListViewState,
        action: DiaryListAction
    ): DiaryListViewState {
        return when (action) {
            is DiaryListAction.FetchedDiaryAction -> {
                currentState.copy(
                    showLoading = false,
                    diaryList = action.value
                )
            }
            DiaryListAction.FetchingDiaryAction -> {
                currentState.copy(
                    showLoading = false
                )
            }
            else -> currentState
        }
    }
}