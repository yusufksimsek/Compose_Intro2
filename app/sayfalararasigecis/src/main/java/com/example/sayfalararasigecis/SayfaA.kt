package com.example.sayfalararasigecis

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun SayfaA(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sayfa A",fontSize = 50.sp)

        Button(onClick = {
            navController.navigate("sayfa_b")
            {
                popUpTo("sayfa_a"){inclusive=true}
             } //Böylece Sayfa A'yı backstackten siler
        }) {
            Text(text = "Sayfa B'ye Git")
        }

        Button(onClick = {
            navController.navigate("anasayfa")
        }) {
            Text(text = "Geri dön")
        }

    }
}