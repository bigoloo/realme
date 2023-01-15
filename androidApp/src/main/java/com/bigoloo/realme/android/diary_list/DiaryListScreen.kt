package com.bigoloo.realme.android.diary_list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.bigoloo.realme.domain.model.Diary
import org.koin.androidx.compose.get
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DiaryListScreen(
    modifier: Modifier,
    navHostController: NavHostController,
    diaryListViewModel: DiaryListViewModel = get()
) {

    Scaffold(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate("addDiary")
                },
                shape = CircleShape,
                backgroundColor = Color.Blue,
                contentColor = Color.White
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }, content = {

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

            }
        })
}

@Composable
fun DiaryList(state: State<List<Diary>>) {
    if (state.value.isEmpty()) {
        Text(text = "No Diary")
    } else {
        LazyColumn() {
            items(state.value) { diary ->
                Card(modifier = Modifier.padding(10.dp)) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "mood: ${diary.mood}")
                        val date = remember {
                            mutableStateOf(
                                SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Date(diary.createTimestamp))
                                    .toString()
                            )
                        }
                        Text(text = "createAt: ${date.value}")
                    }
                }
            }
        }
    }
}
