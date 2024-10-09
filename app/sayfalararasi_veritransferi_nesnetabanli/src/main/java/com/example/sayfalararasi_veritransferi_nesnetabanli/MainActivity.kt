package com.example.sayfalararasi_veritransferi_nesnetabanli

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sayfalararasi_veritransferi_nesnetabanli.ui.theme.ComposeIntro2Theme
import com.google.gson.Gson

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
                    sayfaGecisleri()
                }
            }
        }
    }
}

@Composable
fun sayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable("sayfa_a/{nesne}",
            arguments = listOf(
                navArgument("nesne"){type = NavType.StringType},
            )
        ){
            val json = it.arguments?.getString("nesne")
            val nesne = Gson().fromJson(json,Kisiler::class.java)
            SayfaA(navController = navController,nesne)
        }
        composable("sayfa_b"){
            SayfaB()
        }
    }
}

@Composable
fun Anasayfa(navController: NavController) {
    val sayac = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Anasayfa",fontSize = 50.sp)

        Button(onClick = {
            val kisi = Kisiler("Yusuf",23,1.83f,false)
            val kisiJson = Gson().toJson(kisi)
            navController.navigate("sayfa_a/$kisiJson")
        }) {
            Text(text = "Sayfa A'ya Git")
        }

        Text(text = "Sayaç : ${sayac.value}")

        Button(onClick = {
            sayac.value = sayac.value + 1
        }) {
            Text(text = "Tıkla")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntro2Theme {

    }
}