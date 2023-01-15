package com.bigoloo.realme.domain.diary_list

import com.bigoloo.realme.domain.repository.DiaryRepository
import com.bigoloo.realme.redux.Middleware
import com.bigoloo.realme.redux.Store
import com.bigoloo.realme.ui.diary_list.DiaryListViewState

class DiaryListMiddleware(private val diaryRepository: DiaryRepository) :
    Middleware<DiaryListViewState, DiaryListAction> {
    override suspend fun process(
        action: DiaryListAction,
        currentState: DiaryListViewState,
        store: Store<DiaryListViewState, DiaryListAction>
    ) {
        when (action) {
            DiaryListAction.FetchDiaryList -> fetchDiaryList(store)
            else -> {

            }
        }
    }

    private suspend fun fetchDiaryList(store: Store<DiaryListViewState, DiaryListAction>) {
        store.dispatch(DiaryListAction.FetchingDiaryAction)
        store.dispatch(DiaryListAction.FetchedDiaryAction(diaryRepository.getDiaryListFlow()))
    }
}