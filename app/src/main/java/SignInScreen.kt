import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

// composable building block for UI
@Composable
fun SignInScreen(navController: NavController, auth: FirebaseAuth) {

    // this are state values which will be monitored.
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }


    // layout that places the children in a vertical sequence
    Column(
        modifier = Modifier    //fill max size makes the column take up the entire available space.
            .fillMaxSize()
            .padding(16.dp),    //Adds padding around the column.
        verticalArrangement = Arrangement.Center,    //Centers the children vertically.
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = email,       // The current value of the text field
            onValueChange = { email = it },           //updates the state when the text field value changes.
            label = { Text("Email") },            //A label for the text field.
            modifier = Modifier.fillMaxWidth()         // Makes the text field take the full width of the parent.
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },             //updates the states when the text field value changes.
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
         //   visualTransformation = PasswordVisualTransformation()
        )

        // spacer A composable used to create space between components
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            signIn(email, password, auth) { success, error ->
                if (success) {
                    navController.navigate("main")
                } else {
                    errorMessage = error ?: "Sign-in failed"
                }
            }
        })
        //onclick It calls the signIn function and navigates to the "main" screen if successful,
        // otherwise sets an error message.

        {
            Text("Sign In")
        }
        if (errorMessage.isNotEmpty()) {
            //Text(text = errorMessage, color = Color.Red)
        }
    }
}


// we define the sign in function that the button will call
// first we have an instance of Firebase Authentication.
private fun signIn(email: String, password: String, auth: FirebaseAuth, onResult: (Boolean, String?) -> Unit) {
    auth.signInWithEmailAndPassword(email, password)   // method for signing in someone
        .addOnCompleteListener { task ->       //This listener checks if the sign-in was successful.
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
   val navController = rememberNavController()
    val auth = FirebaseAuth.getInstance()
    SignUpScreen(navController, auth)
}