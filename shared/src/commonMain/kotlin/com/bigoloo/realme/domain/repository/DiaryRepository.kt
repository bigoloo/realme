package com.bigoloo.realme.domain.repository

import com.bigoloo.realme.domain.model.Diary
import kotlinx.coroutines.flow.Flow

interface DiaryRepository {

    suspend fun addDiary(diary: Diary)
    fun getDiaryListFlow(): Flow<List<Diary>>
}