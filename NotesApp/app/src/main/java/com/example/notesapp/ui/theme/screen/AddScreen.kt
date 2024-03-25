package com.example.notesapp.ui.theme.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.data.NotesState
import com.example.notesapp.ui.theme.NotesEvents

@Composable
fun AddScreen(
    state: NotesState,
    navController: NavController,
    onEvent: (NotesEvents)-> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(NotesEvents.SaveNote(state.title.value,state.description.value))
            }) {
                Icon(imageVector = Icons.Default.Done, contentDescription = "Save Notes")
            }
        }
    ) {contentpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentpadding)
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.title.value,
                onValueChange = {
                    state.title.value = it
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                ),
                placeholder = {
                    Text(text = "Title")
                }
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                value = state.description.value,
                onValueChange = {
                    state.description.value = it
                },
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                ),
                placeholder = {
                    Text(text = "Description")
                }
            )
        }

    }
}