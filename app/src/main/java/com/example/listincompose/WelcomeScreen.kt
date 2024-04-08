package com.example.listincompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.listincompose.components.BottomButtonRow
import com.example.listincompose.components.CTButton

@Composable
fun WelcomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )
            Text(
                text = "Welcome",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight(700)
            )
            Text(
                text = "Do meditation, Stay focused.\nLive a healthy Life.",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.weight(1f))

            CTButton(
                navController = navController,
                textValue = "Sign In with Email",
                route = "LoginScreen"
            )

            BottomButtonRow()

        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}