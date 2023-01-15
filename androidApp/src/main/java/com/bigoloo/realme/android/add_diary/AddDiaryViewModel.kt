package com.bigoloo.realme.android.add_diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bigoloo.realme.domain.add_diary.AddDiaryAction
import com.bigoloo.realme.domain.add_diary.AddDiaryStore
import com.bigoloo.realme.ui.add_diary.AddDiaryVewState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddDiaryViewModel(private val addDiaryStore: AddDiaryStore) : ViewModel() {

    fun dispatch(addDiaryAction: AddDiaryAction) {
        viewModelScope.launch {
            addDiaryStore.dispatch(addDiaryAction)
        }
    }

    val viewState: StateFlow<AddDiaryVewState>
        get() = addDiaryStore.state
}