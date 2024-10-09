package com.example.navigationbar_kullanimi

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationbar_kullanimi.ui.theme.ComposeIntro2Theme

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
                    NavigationBarSayfa()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationBarSayfa() {
    val items = listOf("Bir", "İki")
    val secilenItem = remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Başlık") })
        },
        content = {
            if(secilenItem.value == 0){
                SayfaBir()
            }
            if(secilenItem.value == 1){
                SayfaIki()
            }
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = secilenItem.value == index,
                        onClick = { secilenItem.value = index },
                        label = { Text(text = item)},
                        icon = {
                            when(item){
                                "Bir" -> androidx.compose.material3.Icon(
                                    painter = painterResource(id = R.drawable.icon_one),
                                    contentDescription = ""
                                )
                                "İki" -> androidx.compose.material3.Icon(
                                    painter = painterResource(id = R.drawable.icons_two),
                                    contentDescription = ""
                                )
                            }
                        }
                    )
                }
            }
        }
    )


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntro2Theme {
        NavigationBarSayfa()
    }
}