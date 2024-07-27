import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SignInScreen(navController: NavController, auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
         //   visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            signIn(email, password, auth) { success, error ->
                if (success) {
                    navController.navigate("main")
                } else {
                    errorMessage = error ?: "Sign-in failed"
                }
            }
        }) {
            Text("Sign In")
        }
        if (errorMessage.isNotEmpty()) {
            //Text(text = errorMessage, color = Color.Red)
        }
    }
}

private fun signIn(email: String, password: String, auth: FirebaseAuth, onResult: (Boolean, String?) -> Unit) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, null)
            } else {
                onResult(false, task.exception?.message)
            }
        }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
   //val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()
    SignUpScreen(navController, auth)
}