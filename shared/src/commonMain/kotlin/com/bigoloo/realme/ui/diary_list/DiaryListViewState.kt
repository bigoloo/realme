package com.bigoloo.realme.ui.diary_list

import com.bigoloo.realme.domain.model.Diary
import com.bigoloo.realme.redux.State
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class DiaryListViewState(
    @SerialName("diaryList")
    val diaryList: Flow<List<Diary>>,
    @SerialName("showLoading")
    val showLoading: Boolean
) : State