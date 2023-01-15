package com.bigoloo.realme.di

import com.bigoloo.realme.data.repository.InMemoryDiaryRepository
import com.bigoloo.realme.domain.add_diary.AddDiaryStore
import com.bigoloo.realme.domain.diary_list.DiaryListStore
import com.bigoloo.realme.domain.repository.DiaryRepository
import org.koin.dsl.module

val diaryModule = module {
    single<DiaryRepository> {
        InMemoryDiaryRepository()
    }

    factory {
        AddDiaryStore(get())
    }

    factory {
        DiaryListStore(get())
    }
}