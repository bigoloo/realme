package com.bigoloo.realme.android.di

import com.bigoloo.realme.android.add_diary.AddDiaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidAppModule = module {
    viewModel {
        AddDiaryViewModel(get())
    }
}