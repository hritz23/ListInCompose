package com.example.listincompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextField(onValueChange : (String) -> Unit ={}, hint : String, value:String){
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(fontSize = 18.sp, color = Color(0xFFBEC2C2))
            )
        },
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFFBEC2C2),
            unfocusedIndicatorColor = Color(0xFFBEC2C2)
        )
    )
}