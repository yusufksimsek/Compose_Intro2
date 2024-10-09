package com.example.dropdown_menu_kullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dropdown_menu_kullanimi.ui.theme.ComposeIntro2Theme

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
                    dropdownMenu()
                }
            }
        }
    }
}

@Composable
fun dropdownMenu() {
    val menuAcilisKontrol = remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box{
            Button(onClick = {
                menuAcilisKontrol.value = true

            }) {
                Text(text = "Göster")
            }

            DropdownMenu(
                expanded = menuAcilisKontrol.value,
                onDismissRequest = { menuAcilisKontrol.value = false }) {
                DropdownMenuItem(
                    text={Text("Sil")},
                    onClick={menuAcilisKontrol.value = false}
                )
                DropdownMenuItem(
                    text={Text("Düzenle")},
                    onClick={menuAcilisKontrol.value = false})
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntro2Theme {
        dropdownMenu()
    }
}