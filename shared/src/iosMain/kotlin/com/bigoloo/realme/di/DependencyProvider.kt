package com.bigoloo.realme.di

import com.bigoloo.realme.domain.add_diary.AddDiaryStore
import com.bigoloo.realme.domain.diary_list.DiaryListStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class AddDiaryDependencyHelper : KoinComponent {
    private val addDiaryStore: AddDiaryStore by inject()
    fun getAddDiaryStore(): AddDiaryStore {
        return addDiaryStore
    }
}

class DiaryListDependencyHelper : KoinComponent {
    private val diaryListStore: DiaryListStore by inject()
    fun getDiaryListStore(): DiaryListStore {
        return diaryListStore
    }
}

fun initKoin() {
    startKoin {
        modules(diaryModule)
    }
}