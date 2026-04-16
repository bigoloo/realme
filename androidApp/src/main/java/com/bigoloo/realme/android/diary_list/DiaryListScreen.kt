package com.bigoloo.realme.android.diary_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.bigoloo.realme.domain.model.Diary
import org.koin.compose.viewmodel.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DiaryListScreen(
    modifier: Modifier,
    navHostController: NavHostController,
    diaryListViewModel: DiaryListViewModel = koinViewModel()
) {

    Scaffold(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(), floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navHostController.navigate("addDiary")
            }, shape = CircleShape, containerColor = Color.Blue, contentColor = Color.White
        ) {

            //TODO Add Proper icon
            /*Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Diary"
            )*/

        }
    }, content = { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            val state = diaryListViewModel.viewState.collectAsStateWithLifecycle()
            if (state.value.showLoading) {
                CircularProgressIndicator()
            }
            val diaryList by state.value.diaryList.collectAsStateWithLifecycle(initialValue = emptyList())
            DiaryList(diaryList)

            Spacer(modifier = Modifier.weight(1f))

        }
    })
}

@SuppressLint("SimpleDateFormat")
@Composable
fun DiaryList(diaryList: List<Diary>) {
    if (diaryList.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = "No Diary")
        }
    } else {
        LazyColumn() {
            items(diaryList) { diary ->
                Card(modifier = Modifier.padding(8.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(text = "Mood: ${diary.mood}")
                        val date = remember {
                            mutableStateOf(
                                SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date(diary.createTimestamp))
                                    .toString()
                            )
                        }
                        Text(text = "Created at: ${date.value}")
                    }
                }
            }
        }
    }
}
