package com.example.MazeConnect.features.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
// import androidx.compose.material.BottomNavigationBar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.MazeConnect.features.homescreen.R
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen() {
    // Define the state for the search bar
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->  // Add paddingValues to apply content padding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)  // Apply the scaffold content padding here
                .padding(16.dp) // Additional padding for internal content
        ) {
            Text(
                text = "Explore",
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Search Bar
            OutlinedTextField(
                value = searchQuery, // Use the state value here
                onValueChange = { searchQuery = it }, // Update the state
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text(text = "Search...")
                },
                leadingIcon = {
                    Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                },
                shape = RoundedCornerShape(50),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Image for Explore Events Section
            Image(
                painter = painterResource(id = R.drawable.explore_image), // Replace with your image resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nearby Events Text Section
            Text(
                text = "Nearby Events",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "Find the next available event!",
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Events Card
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                EventCard(title = "Tech Talk", location = "Nymo County")
                EventCard(title = "Workshop", location = "Phylo Labs")
            }
        }
    }
}

@Composable
fun EventCard(title: String, location: String) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(180.dp)
            .height(120.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.event_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = location,
                style = MaterialTheme.typography.body2.copy(color = Color.Gray),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) }
        )

        BottomNavigationItem(
            selected = false,
            onClick = {},
            label = { Text("Events") },
            icon = { Icon(Icons.Default.CalendarToday, contentDescription = null) }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            label = { Text("Profile") },
            icon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen() // Call the actual HomeScreen composable here
}


