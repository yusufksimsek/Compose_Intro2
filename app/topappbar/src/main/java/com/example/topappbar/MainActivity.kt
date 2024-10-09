package com.example.topappbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.topappbar.ui.theme.ComposeIntro2Theme

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
                    SayfaTopAppBarArama()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaTopAppBarArama() {
    val aramaYapiliyorMu = remember { mutableStateOf(false) }
    val tf = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(aramaYapiliyorMu.value){
                        TextField(value = tf.value, onValueChange = {
                            tf.value = it
                            Log.e("Arama","Arama: $it")
                        },
                        label = {
                            Text(text = "Ara")
                        })
                    }else{
                        Text(text = "Başlık")
                    }
                },
                actions = {
                    if(aramaYapiliyorMu.value){
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.cancel),
                                contentDescription = "")
                        }
                    }else{
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.search),
                                contentDescription = "")
                        }
                    }
                }
            )
        },
        content = {
            //Sayfa tasarım içeriği
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaTopAppBar() {
    val menuAcilisKontrol = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Başlık")
                        Text(text = "Alt Başlık",fontSize = 12.sp)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700),//Arkaplan rengi
                    titleContentColor = colorResource(id = R.color.white),//İçerik Rengi
                ),
                actions = {
                    Text(text = "Çıkış", modifier = Modifier.clickable { Log.e("TopBar", "Çıkış Seçildi") })
                    IconButton(onClick = { Log.e("TopBar", "Info Seçildi") }) {
                        Icon(painter = painterResource(id = R.drawable.logout), contentDescription = "")
                    }
                    IconButton(onClick = { menuAcilisKontrol.value = true }) {
                        Icon(painter = painterResource(id = R.drawable.more), contentDescription = "")
                    }
                    DropdownMenu(
                        expanded = menuAcilisKontrol.value,
                        onDismissRequest = { menuAcilisKontrol.value = false }) {
                        DropdownMenuItem(
                            onClick = {
                                Log.e("TopBar", "Menu sil seçildi")
                                menuAcilisKontrol.value = false
                            }, text = { Text("Sil") },
                        )
                        DropdownMenuItem(
                            onClick = {
                                Log.e("TopBar", "Menu güncelle seçildi")
                                menuAcilisKontrol.value = false
                            }, text = { Text("Güncelle") },
                        )
                    }
                }
            )
        },
        content = {
            //Sayfa tasarım içeriği
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntro2Theme {
        SayfaTopAppBarArama()
    }
}