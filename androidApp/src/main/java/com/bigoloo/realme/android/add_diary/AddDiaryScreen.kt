package com.bigoloo.realme.android.add_diary

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.get


@Composable
fun AddDiaryScreen(modifier: Modifier, addDiaryViewModel: AddDiaryViewModel = get()) {

    Column(modifier = modifier) {
        Text(text = "Hello world!!!")
    }
}