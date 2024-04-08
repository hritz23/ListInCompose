package com.example.listincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listincompose.data.DataProvider
import com.example.listincompose.data.Puppy
import com.example.listincompose.ui.theme.ListInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListInComposeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.primary)
                ) {}
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "WelcomeScreen",
                    builder = {
                        composable("MainActivity") {
                            BarkHomeContent(navController)
                        }
                        composable("WelcomeScreen") {
                            WelcomeScreen(navController)
                        }
                        composable("LoginScreen") {
                            LoginScreen(navController)
                        }
                        composable(
                            "ProfileActivity/{puppy.id}",
                            arguments = listOf(navArgument("puppy.id") { type = NavType.IntType })
                        ) { navBackStack ->
                            val puppyId = navBackStack.arguments?.getInt("puppy.id")!!
                            ProfileNavigation(navController, puppyId)
                        }
                    })
            }

        }
    }
}

@Composable
fun ListItem() {
    var context = LocalContext.current
    var personList = listOf(
        "Ruth",
        "tttt",
        "aaaa",
        "Ruth",
        "tttt",
        "aaaa",
        "bbbb",
        "cccc",
        "DDD",
        "eeee",
        "ttttt",
        "pppp",
        "DDD",
        "eeee",
        "ttttt",
        "pppp"
    )
    LazyColumn {
        items(
            items = personList,
            itemContent = { person ->
                Text(text = person, modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        Toast
                            .makeText(context, "$person", Toast.LENGTH_SHORT)
                            .show()
                    }
                )
                Divider()
            }
        )
    }
}


@Composable
fun BarkHomeContent(navController: NavController) {
    val context = LocalContext.current
    val puppies = remember { DataProvider.puppyList }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(
            items = puppies,
            itemContent = { puppy ->
                PuppyListItem(puppy = puppy) {
                    // Handle item click here
                    Toast.makeText(context, "Clicked on ${puppy.title}", Toast.LENGTH_SHORT).show()
                    navController.navigate("ProfileActivity/${puppy.id}")
                }
            }
        )
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, onItemClick: (Puppy) -> Unit) {
    val rainbowColorsBrush = remember {
        Brush.sweepGradient(
            listOf(
                Color(0xFF9575CD),
                Color(0xFFBA68C8),
                Color(0xFFE57373),
                Color(0xFFFFB74D),
                Color(0xFFFFF176),
                Color(0xFFAED581),
                Color(0xFF4DD0E1),
                Color(0xFF9575CD)
            )
        )
    }
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(puppy) }, // Adding clickable modifier here
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        border = BorderStroke(1.dp, Color.DarkGray)

    ) {
        Row {
            Image(
                painter = painterResource(puppy.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(BorderStroke(2.dp, rainbowColorsBrush), RoundedCornerShape(16.dp))
                    .blur(radius = 4.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = puppy.title, style = MaterialTheme.typography.headlineSmall)
                Text(text = "View Detail", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListInComposeTheme {
    }
}