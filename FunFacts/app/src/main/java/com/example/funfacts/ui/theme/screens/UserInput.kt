package com.example.funfacts.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.funfacts.R
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.ui.theme.AnimalImage
import com.example.funfacts.ui.theme.ButtonComponent
import com.example.funfacts.ui.theme.TextComponent
import com.example.funfacts.ui.theme.TextFieldComponent
import com.example.funfacts.ui.theme.TopBar
import com.example.funfacts.ui.theme.UserInputViewModel

@Composable
fun UserInput(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen : (valuesPair : Pair<String,String>) -> Unit
) {
   Surface(
       modifier = Modifier
           .fillMaxSize()
   ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar(value = "Hi there \uD83D\uDE00", textSize = 24.sp)
            TextComponent(
                textValue = "Let's learn fun !",
                textSize = 24.sp,
                fontWeightValue = FontWeight.Light
            )
            Spacer(modifier = Modifier.size(10.dp))
            TextComponent(
                textValue = "Here we will prepare for you more fun facts",
                textSize = 20.sp,
                fontWeightValue = FontWeight.ExtraLight
            )
            Spacer(modifier = Modifier.size(60.dp))
            TextComponent(
                textValue = "Name",
                textSize = 24.sp,
                fontWeightValue = FontWeight.Normal
            )
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(
                textValue = "What do you like",
                textSize = 20.sp,
                fontWeightValue = FontWeight.W300
            )
            Spacer(modifier = Modifier.size(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1f))
                AnimalImage(imgId = R.drawable.pexels_alexandru_rotariu_733416_removebg_preview, imgSize = 108.dp, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animal=="Dog")
                Spacer(modifier = Modifier.weight(1f))
                AnimalImage(imgId = R.drawable.pexels_pixabay_104827__1__removebg_preview, imgSize = 100.dp,animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                },selected = userInputViewModel.uiState.value.animal=="Cat")
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.weight(1f))
            if (userInputViewModel.isAllGiven()){
                ButtonComponent(
              gotoDetailsScreen = {
                    println("===Coming")
                    println("===${userInputViewModel.uiState.value.animal}")
                  showWelcomeScreen(
                      Pair(
                          userInputViewModel.uiState.value.name,
                          userInputViewModel.uiState.value.animal
                      )
                  )
                }
                )
            }
        }
   }
}

@Preview
@Composable
fun UserInputPreview(){
    val userInputViewModel = UserInputViewModel()
    val navController = rememberNavController()
    UserInput(userInputViewModel,showWelcomeScreen={
        println(it.first)
        println(it.second)
        navController.navigate(Routes.WELCOME_SCREEN)
    })
}