package com.bigoloo.realme.domain.add_diary

import com.bigoloo.realme.domain.model.Diary
import com.bigoloo.realme.domain.repository.DiaryRepository
import com.bigoloo.realme.redux.Middleware
import com.bigoloo.realme.redux.Store
import com.bigoloo.realme.ui.add_diary.AddDiaryVewState

class AddDiaryMiddleware(private val diaryRepository: DiaryRepository) :
    Middleware<AddDiaryVewState, AddDiaryAction> {
    override suspend fun process(
        action: AddDiaryAction,
        currentState: AddDiaryVewState,
        store: Store<AddDiaryVewState, AddDiaryAction>
    ) {
        when (action) {
            is AddDiaryAction.AddNewDiaryAction -> {
                addNewDiary(store, action.diary)
            }
            else -> {

            }
        }
    }

    private suspend fun addNewDiary(store: Store<AddDiaryVewState, AddDiaryAction>, diary: Diary) {
        store.dispatch(AddDiaryAction.SavingDiaryAction)
        diaryRepository.addDiary(diary)
        store.dispatch(AddDiaryAction.SavedDiaryAction)
    }
}