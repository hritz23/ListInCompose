package com.example.listincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.listincompose.data.DataProvider
import com.example.listincompose.data.Puppy
import com.example.listincompose.ui.theme.ListInComposeTheme

class ProfileDetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun ProfileNavigation(navController: NavController, puppyId: Int) {
    ProfileDetails(puppyId)
}

@Composable
fun ProfileDetails(puppyId: Int, modifier: Modifier = Modifier.fillMaxSize()) {
    val puppies = remember { DataProvider.puppyList } // Remember the puppy list
    val puppy = puppies.find { it.id == puppyId }
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.primaryContainer)
        ) {
            ProfileHeader(
                rememberScrollState(),
                puppy!!,
                modifier.fillMaxHeight(1f)
            )
            ProfileContent(puppy, modifier.fillMaxHeight(1f))
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    puppy: Puppy,
    modifier: Modifier
) {
    val offset = (scrollState.value / 2)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = offsetDp),
        painter = painterResource(id = puppy.imageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(puppy: Puppy, modifier: Modifier) {
    Column {
        Spacer(modifier = Modifier.padding(8.dp))

        Text(
            text = puppy.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        ProfileProperty("Gender: ", puppy.gender)

        ProfileProperty("Age: ", puppy.age.toString())

        ProfileProperty("Description: ", puppy.description)
    }
}

@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        Row(Modifier.padding(top = 16.dp)) {
            Text(text = label, style = MaterialTheme.typography.labelMedium)
            Text(
                text = value,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    ListInComposeTheme {
        ProfileDetails(2)
    }
}