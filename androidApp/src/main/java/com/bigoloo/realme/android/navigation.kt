package com.bigoloo.realme.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bigoloo.realme.android.add_diary.AddDiaryScreen
import com.bigoloo.realme.android.diary_list.DiaryListScreen

@Composable
fun MainNavigation(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = "diaryList"
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable("addDiary") {
            AddDiaryScreen(modifier, navController)
        }
        composable("diaryList") {
            DiaryListScreen(modifier = modifier, navHostController = navController)
        }
    }

}