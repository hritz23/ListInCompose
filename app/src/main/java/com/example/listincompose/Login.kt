package com.example.listincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listincompose.ui.theme.ListInComposeTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun OutLineTextFieldSample() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            label = { Text(text = "Full Name") },
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription ="Email Icon")},
//            trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription ="Add")},
            value = email,
            label = { Text(text = "Email") },
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter your mail") }
        )
    }
}

@Composable
fun MyLoginApp() {
    OutLineTextFieldSample()
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ListInComposeTheme {
        MyLoginApp()
    }
}