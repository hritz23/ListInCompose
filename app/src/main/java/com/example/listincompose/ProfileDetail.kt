package com.example.listincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listincompose.ui.theme.ListInComposeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class ProfileDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ProfileNavigation(navController: NavController) {
    ProfileDetails()
}

@Composable
fun ProfileDetails(modifier: Modifier = Modifier.fillMaxSize()) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(R.drawable.p1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.weight(0.5f)
        )
            Text(
                text = "Monty",
                modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(text = "Monty", modifier.padding(16.dp), fontSize = 12.sp)
            Text(text = "Monty", modifier.padding(16.dp), fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ListInComposeTheme {
        ProfileDetails()
    }
}