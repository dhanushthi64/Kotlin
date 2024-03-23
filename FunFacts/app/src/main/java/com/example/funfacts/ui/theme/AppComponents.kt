package com.example.funfacts.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfacts.R
import com.example.funfacts.Utils
import com.example.funfacts.data.UserDataUiEvents

@Composable
fun TopBar(
    value: String,
    textSize : TextUnit
){
   Row(
       modifier = Modifier
           .fillMaxWidth(),
       verticalAlignment = Alignment.CenterVertically
   ) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = textSize,
            fontWeight = FontWeight.Medium
        )
       Spacer(modifier = Modifier.weight(1f))
       Image(
           painter = painterResource(id = R.drawable.funfacts_high_resolution_logo_transparent),
           contentDescription = "Dhanush Facts",
           modifier = Modifier.size(80.dp)
       )
   }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar("Hi there \uD83D\uDE00", textSize = 24.sp)
}

@Composable
fun TextComponent(
    textValue : String,
    textSize : TextUnit,
    colorValue : Color = Color.Black,
    fontWeightValue : FontWeight,

){
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = fontWeightValue,

    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "Dhanush", textSize = 24.sp, fontWeightValue = FontWeight.Light)
}

@Composable
fun TextFieldComponent(
    onTextChanged : (name: String) -> (Unit)
){
    var currentValue by remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange ={
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(
            fontSize = 24.sp
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview(){
    val userInputViewModel = UserInputViewModel()
    TextFieldComponent(
        onTextChanged = {
            userInputViewModel.onEvent(
                UserDataUiEvents.UserNameEntered(it)
            )
        }
    )
}

@Composable
fun AnimalImage(
    @DrawableRes imgId : Int,
    imgSize : Dp,
    selected : Boolean,
    animalSelected : (animalName: String) -> Unit
){
    val localFocusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .padding(15.dp)
            .size(120.dp)
            .shadow(

                elevation = 4.dp,
                clip = false,
                shape = RoundedCornerShape(8.dp),
                ambientColor = DefaultShadowColor,
                spotColor = DefaultShadowColor
            ),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Red else Color.Transparent,
                    shape = RoundedCornerShape(16.dp)
                )

        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = null,
                modifier = Modifier
                    .size(imgSize)
                    .padding(10.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val animalName =
                            if (imgId == R.drawable.pexels_pixabay_104827__1__removebg_preview) "Cat" else "Dog"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalImagePreview(){
    val userInputViewModel = UserInputViewModel()
    AnimalImage(imgId = R.drawable.pexels_alexandru_rotariu_733416_removebg_preview, imgSize = 108.dp, animalSelected = {
        userInputViewModel.onEvent(
            UserDataUiEvents.AnimalSelected(it)
        )
    }, selected = userInputViewModel.uiState.value.animal=="Cat")
}

@Composable
fun ButtonComponent(
   gotoDetailsScreen: () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {
                  gotoDetailsScreen()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Green
        )
    ) {
        TextComponent(textValue = "Next", textSize = 18.sp, fontWeightValue = FontWeight.Bold, colorValue = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview(){
    val userInputViewModel= UserInputViewModel()
    ButtonComponent(
        gotoDetailsScreen = {
            println("===Coming")
            println("${userInputViewModel.uiState.value}")
        }
    )
}

@Composable
fun AnimalText(
    animalname : String?
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        TextWithShadow(textValue = "You are a ${animalname} Lover")
        Spacer(modifier = Modifier.width(5.dp))
        when(animalname){
            "Dog" ->{
                TextWithShadow(textValue = "\uD83D\uDC36")

            }
            "Cat" ->{
               TextWithShadow(textValue = "\uD83D\uDC31")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalTextPreview(){
    AnimalText(animalname = "Cat")
}

@Composable
fun TextWithShadow(textValue: String, modifier: Modifier = Modifier){
    val shadowOffset = Offset(x= 1f , y= 2f)
    Text(
        text = textValue,
        fontSize = 24.sp,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(
                Utils.generateColor(),
                shadowOffset,
                2f
            ),
        )
    )
}

@Composable
fun FactsComponent(

    animalname: String?
){
    val factsViewModel = FactsViewModel()
    Card(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .size(200.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(8.dp),

    ) {
        Row(
            modifier = Modifier
                .padding(18.dp,24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when(animalname){
                "Dog" -> {
                    TextWithShadow(textValue = factsViewModel.generateRandomFacts(animalname), modifier = Modifier.padding(10.dp) )
                }
                "Cat" -> {
                    TextWithShadow(textValue = factsViewModel.generateRandomFacts(animalname),modifier = Modifier.padding(10.dp))
                }
            }
        }

    }
}