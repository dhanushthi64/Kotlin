package com.example.greeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greeting.ui.theme.GreetingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GreetingImage("Dhanush")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
        ) {
        Text(
            text = "Happy Birthday $name",
            lineHeight = 116.sp,
            fontSize = 90.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "From Mukesh",
            fontSize = 36.sp,
            modifier = modifier
                .padding(
                    top = 30.dp
                )
                .align(alignment = Alignment.CenterHorizontally),
        )
    }
}

@Composable
fun GreetingImage(message : String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
    }
    Greeting(
        name = "Dhanush",
    )
}

@Preview(showBackground = true,
    showSystemUi = true,
    name = "Dhanush",
    )
@Composable
fun GreetingPreview() {
    GreetingTheme {
        Greeting(name = "Dhanush")
        GreetingImage("Hi")
    }
}