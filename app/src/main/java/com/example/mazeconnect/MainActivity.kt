package com.example.mazeconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mazeconnect.ui.theme.MazeConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         WindowCompat.setDecorFitsSystemWindows(window, false)
        // firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        enableEdgeToEdge()
        setContent {
            MazeConnectTheme {
                //val viewmodel: MazeViewModel = koinViewModel()
                // MyApplication(viewmodel.current)
                MazeConnectApp()
                }
            }
        }
    }


@Composable
fun MazeConnectApp() {// research if this should be in separate .kt file with diff feature graph() s
    MazeConnectTheme {
        NavGraph()
    }
}