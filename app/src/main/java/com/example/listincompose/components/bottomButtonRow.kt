package com.example.listincompose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomButtonRow(){
    Row(modifier = Modifier.padding(top = 8.dp,bottom = 24.dp)){
        Text(text = "Don't have an account? ", fontSize = 14.sp, color = Color.White)
        Text(text = "Sign Up", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Black)
    }
}