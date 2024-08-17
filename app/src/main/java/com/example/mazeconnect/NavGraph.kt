package com.example.mazeconnect

import SignInScreen
import SignUpScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavGraph(startDestination: String = "sign_in") {
    val navController = rememberNavController()   //Creates a NavController that will be remembered across recompositions.
    val auth = FirebaseAuth.getInstance()


    //nav host A composable that provides a container for navigation within the app.
    NavHost(navController = navController, startDestination = startDestination) {
        composable("sign_in") {
            SignInScreen(navController, auth)


        }
        composable("sign_up") {
            SignUpScreen(navController, auth)
        }
        composable("main") {
            MainScreen()
        }
        // composable functions here as I create new screens
    }
}
