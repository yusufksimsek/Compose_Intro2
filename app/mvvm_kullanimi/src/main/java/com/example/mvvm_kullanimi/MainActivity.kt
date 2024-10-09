package com.example.mvvm_kullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_kullanimi.ui.theme.ComposeIntro2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntro2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val tfSayi1 = remember { mutableStateOf("") }
    val tfSayi2 = remember { mutableStateOf("") }

    val viewModel : SayfaViewModel = viewModel()
    val sonuc = viewModel.sonuc.observeAsState("0")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
            Text(text = sonuc.value, fontSize = 50.sp)

            TextField(
                value = tfSayi1.value,
                onValueChange = { tfSayi1.value=it },
                label = { Text(text = "Sayı 1")})

            TextField(
            value = tfSayi2.value,
            onValueChange = { tfSayi2.value=it },
            label = { Text(text = "Sayı 2")})
        
            Button(onClick = {
                viewModel.toplamaYap(tfSayi1.value,tfSayi2.value)
            }) {
                Text(text = "Toplama")
            }

            Button(onClick = {
                viewModel.carpmaYap(tfSayi1.value,tfSayi2.value)
        }) {
                Text(text = "Çarpma")
        }
        
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntro2Theme {
        Sayfa()
    }
}