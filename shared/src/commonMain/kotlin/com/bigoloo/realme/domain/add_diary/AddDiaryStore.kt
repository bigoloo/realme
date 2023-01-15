package com.bigoloo.realme.domain.add_diary

import com.bigoloo.realme.domain.repository.DiaryRepository
import com.bigoloo.realme.redux.BaseStore
import com.bigoloo.realme.ui.add_diary.AddDiaryVewState

class AddDiaryStore(private val diaryRepository: DiaryRepository) :
    BaseStore<AddDiaryVewState, AddDiaryAction>(
        initialState = AddDiaryVewState(
            false,
            isSaved = false
        ),
        reducer = AddDiaryReducer(), middlewares = listOf(
            AddDiaryMiddleware(diaryRepository)
        )
    ) {
}