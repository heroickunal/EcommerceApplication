package com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.ecommerceappjetpackcompose.ui.theme.Purple500

@Composable
fun ThankYouScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple500),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Thank You \nFor \n Shopping",
            fontSize = 36.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}