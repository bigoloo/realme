package com.bigoloo.realme.domain.diary_list

import com.bigoloo.realme.domain.repository.DiaryRepository
import com.bigoloo.realme.redux.BaseStore
import com.bigoloo.realme.ui.diary_list.DiaryListViewState

class DiaryListStore(private val diaryRepository: DiaryRepository) :
    BaseStore<DiaryListViewState, DiaryListAction>(
        initialState = DiaryListViewState(diaryRepository.getDiaryListFlow(), false),
        reducer = DiaryListReducer(),
        middlewares = listOf(DiaryListMiddleware(diaryRepository))
    ) {
}