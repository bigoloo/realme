package com.bigoloo.realme.android.di

import com.bigoloo.realme.android.add_diary.AddDiaryViewModel
import com.bigoloo.realme.android.diary_list.DiaryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidAppModule = module {
    viewModel {
        AddDiaryViewModel(get())
    }
    viewModel {
        DiaryListViewModel(get())
    }
}