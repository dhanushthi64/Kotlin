package com.example.notesapp.ui.theme.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.notesapp.data.NotesState
import com.example.notesapp.ui.theme.ItemColor
import com.example.notesapp.ui.theme.NotesEvents
import com.example.notesapp.ui.theme.TextColor
import com.example.notesapp.ui.theme.TopBarColor

@Composable
fun NotesScreen(
    state: NotesState,
    navController: NavController,
    onEvent: (NotesEvents) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(TopBarColor)
                    .padding(16.dp)
                    .clickable {

                    },
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Notes",
                    modifier = Modifier.weight(1f),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextColor
                )
                IconButton(onClick = {
                    onEvent(NotesEvents.SortNotes)
                }) {
                    Icon(imageVector = Icons.Rounded.Sort, contentDescription = "Sort",
                        modifier = Modifier.size(35.dp),
                        tint = TextColor
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                state.title.value = ""
                state.description.value = ""
                navController.navigate("AddScreen")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Notes")
            }
        }
    ) {contentPadding ->
        LazyColumn(
            contentPadding = contentPadding,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.notes.size){ index ->
                NoteItem(state = state, index = index,onEvent= onEvent)
            }
        }

    }
}

@Composable
fun NoteItem(
    state : NotesState,
    index : Int,
    onEvent: (NotesEvents) -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(ItemColor)
            .padding(12.dp)
    ){
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = state.notes[index].title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.notes[index].description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
        IconButton(onClick = {
            onEvent(NotesEvents.DeleteNote(state.notes[index]))
        }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Notes",
                modifier = Modifier.size(35.dp)
                , tint = Color.Black)
        }
    }
}
