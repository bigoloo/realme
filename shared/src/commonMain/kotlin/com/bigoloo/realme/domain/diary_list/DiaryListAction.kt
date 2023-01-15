package com.bigoloo.realme.domain.diary_list

import com.bigoloo.realme.domain.model.Diary
import com.bigoloo.realme.redux.Action
import kotlinx.coroutines.flow.Flow

sealed class DiaryListAction : Action {
    object FetchDiaryList : DiaryListAction()
    object FetchingDiaryAction : DiaryListAction()
    data class FetchedDiaryAction(val value: Flow<List<Diary>>):DiaryListAction()
}