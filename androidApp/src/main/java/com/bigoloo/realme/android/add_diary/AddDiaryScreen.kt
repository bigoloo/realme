package com.bigoloo.realme.android.add_diary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bigoloo.realme.domain.add_diary.AddDiaryAction
import com.bigoloo.realme.domain.model.Diary
import org.koin.androidx.compose.get


@Composable
fun AddDiaryScreen(modifier: Modifier, addDiaryViewModel: AddDiaryViewModel = get()) {

    Column(modifier = modifier) {
        Text(text = "Hello User")
        val state = addDiaryViewModel.viewState.collectAsStateWithLifecycle()
        Text(text = "Current State :${state.value}")
        Text(text = "Choose Your Current Mood (bad =0 , great =5)")

        var selectedValueIndex by remember { mutableStateOf(-1) }
        val moodOption: List<String> by remember {
            mutableStateOf(listOf("0", "1", "2", "3", "4", "5"))
        }

        MoodSection(moodOption, selectedValueIndex) {
            selectedValueIndex = it
        }
        Spacer(modifier = modifier.weight(1f))
        Button(onClick = {
            addDiaryViewModel.dispatch(AddDiaryAction.AddNewDiaryAction(Diary(selectedValueIndex)))
        }) {
            Text(text = "Save")
        }
    }
}

@Composable
fun MoodSection(
    moodOption: List<String>,
    selectedValueIndex: Int,
    onChangeState: (index: Int) -> Unit
) {

    val isSelectedItem: (Int) -> Boolean = { selectedValueIndex == it }
    Column(Modifier.padding(8.dp)) {
        Text(text = "Selected value: ${if (selectedValueIndex == -1) "NONE" else selectedValueIndex}")
        moodOption.forEachIndexed { index, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .selectable(
                        selected = isSelectedItem(index),
                        onClick = { onChangeState(index) },
                        role = Role.RadioButton
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = isSelectedItem(index),
                    onClick = null
                )
                Text(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
