package com.bigoloo.realme.domain.add_diary

import com.bigoloo.realme.domain.model.Diary
import com.bigoloo.realme.redux.Action

sealed class AddDiaryAction : Action {

    data class AddNewDiaryAction(val diary: Diary) : AddDiaryAction()
    object SavingDiaryAction : AddDiaryAction()
    object SavedDiaryAction : AddDiaryAction()
}