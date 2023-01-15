package com.bigoloo.realme.android.diary_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigoloo.realme.domain.diary_list.DiaryListAction
import com.bigoloo.realme.domain.diary_list.DiaryListStore
import com.bigoloo.realme.ui.diary_list.DiaryListViewState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DiaryListViewModel(private val diaryListStore: DiaryListStore) : ViewModel() {

    val viewState: StateFlow<DiaryListViewState>
        get() = diaryListStore.state

    init {
        dispatch(DiaryListAction.FetchDiaryList)
    }

    fun dispatch(action: DiaryListAction) {
        viewModelScope.launch {
            diaryListStore.dispatch(action)
        }
    }

}