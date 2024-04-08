package com.example.listincompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
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
import com.example.listincompose.components.CTextField


@Composable
fun LoginScreen(navController: NavController) {
    Surface(color = Color(0XFF253334), modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .heightIn(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-20).dp)
                )
                Text(
                    text = "Welcome",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight(700), modifier = Modifier.align(Alignment.Start)
                )
                Text(
                    text = "Sign In now to access your exercises and saved music",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                CTextField(hint = "Email Address", value = "")
                CTextField(hint = "Password", value = "")
                Spacer(modifier = Modifier.height(24.dp))
                CTButton(
                    navController = navController,
                    textValue = "Sign In",
                    route = "MainActivity"
                )

                BottomButtonRow()


            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}