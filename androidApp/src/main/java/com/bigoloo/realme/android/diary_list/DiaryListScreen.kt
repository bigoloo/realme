package com.bigoloo.realme.android.diary_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.bigoloo.realme.domain.model.Diary
import org.koin.androidx.compose.get


@Composable
fun DiaryListScreen(
    modifier: Modifier,
    navHostController: NavHostController,
    diaryListViewModel: DiaryListViewModel = get()
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        val state = diaryListViewModel.viewState.collectAsStateWithLifecycle()
        if (state.value.showLoading) {
            CircularProgressIndicator()
        }
        DiaryList(state.value.diaryList.collectAsStateWithLifecycle(initialValue = emptyList()))

        Spacer(modifier = Modifier.weight(1f))
        FloatingActionButton(
            onClick = {
                navHostController.navigate("addDiary")
            },
            shape = RectangleShape,
            backgroundColor = Color.Blue,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }

}

@Composable
fun DiaryList(state: State<List<Diary>>) {
    if (state.value.isEmpty()) {
        Text(text = "No Diary")
    } else {
        LazyColumn() {
            items(state.value) { diary ->
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "mood: ${diary.mood}")
                    Text(text = "createAt: ${diary.createTimestamp}")
                }
            }
        }
    }
}
