package com.example.listincompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listincompose.data.DataProvider
import com.example.listincompose.data.Puppy
import com.example.listincompose.ui.theme.ListInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "MainActivity", builder = {
                composable("MainActivity",){
                    BarkHomeContent(navController)
                }
                composable("ProfileActivity",){
                    ProfileNavigation(navController)
                }
            })
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
                    navController.navigate("ProfileActivity")
                }
            }
        )
    }
}

@Composable
fun PuppyListItem(puppy: Puppy, onItemClick: (Puppy) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(puppy) }, // Adding clickable modifier here
        elevation = CardDefaults.elevatedCardElevation()
    ) {
        Row() {
            Image(
                painter = painterResource(puppy.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(16.dp))
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