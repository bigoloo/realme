package com.bigoloo.realme.data.repository

import com.bigoloo.realme.domain.model.Diary
import com.bigoloo.realme.domain.repository.DiaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class InMemoryDiaryRepository : DiaryRepository {

    private val diaryList = MutableStateFlow<List<Diary>>(listOf<Diary>())
    override suspend fun addDiary(diary: Diary) {
        diaryList.emit(diaryList.value + diary)
    }

    override fun getDiary(): Flow<List<Diary>> {
        return diaryList
    }
}