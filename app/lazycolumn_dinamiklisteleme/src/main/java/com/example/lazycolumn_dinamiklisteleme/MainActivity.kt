package com.example.lazycolumn_dinamiklisteleme

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lazycolumn_dinamiklisteleme.ui.theme.ComposeIntro2Theme

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
    NavHost(navController = navController, startDestination = "sayfa"){
        composable("sayfa"){
            Sayfa(navController = navController)
        }
        composable("detay_sayfa/{ulkeAdi}", arguments = listOf(
            navArgument("ulkeAdi"){type = NavType.StringType}
        )){
            val ulkeAdi = it.arguments?.getString("ulkeAdi")!!
            DetaySayfa(ulkeAdi = ulkeAdi)
        }
    }
}

@Composable
fun Sayfa(navController: NavController) {

    val ulkeListesi = remember { mutableStateListOf("Türkiye","Almanya","ABD","İsveç","İtalya","Japonya") }

    LazyColumn {
        items(
            count = ulkeListesi.count(),
            itemContent = {
                val ulke = ulkeListesi[it]

                Card(modifier = Modifier
                    .padding(all = 5.dp)
                    .fillMaxWidth()) {
                    Row(modifier = Modifier.clickable {  // Bunu sadece tıklama işlemi yapmak için ekliyoruz
                        Log.e("Liste","$ulke seçildi")
                        navController.navigate("detay_sayfa/$ulke")
                    }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth()
                        ) {
                            Text(text = ulke, modifier = Modifier.padding(all = 5.dp))
                            OutlinedButton(onClick = {
                                Log.e("Buton","Buton ile $ulke seçildi")
                            }) {
                                Text(text = "ülke seç")
                            }
                        }
                    }

                }
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    
}