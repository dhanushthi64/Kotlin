package com.example.funfacts.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.ui.theme.AnimalText
import com.example.funfacts.ui.theme.FactsComponent
import com.example.funfacts.ui.theme.TextComponent
import com.example.funfacts.ui.theme.TextWithShadow
import com.example.funfacts.ui.theme.TopBar

@Composable
fun WelcomeScreen(username: String?, animalselected: String?) {
    println("==Inside Welcome")
    println("==${username} and ${animalselected}")
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Welcome ${username} \uD83D\uDE0D", textSize = 20.sp)
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "Thank you for visiting !",
                textSize = 24.sp,
                fontWeightValue = FontWeight.Light
            )
            Spacer(modifier = Modifier.size(60.dp))
            AnimalText(animalname = animalselected)
            Spacer(modifier = Modifier.size(60.dp))
            FactsComponent( animalname = animalselected)

        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "animalselected")
}