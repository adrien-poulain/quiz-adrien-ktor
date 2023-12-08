import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun WelcomeScreen(navigator: Navigator) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            modifier = Modifier.padding(10.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column (
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = "Quiz Adrien POULAIN",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally),

                )
                Text(
                    text = "Ceci est un simple quizz de test donc te trompe pas !!"
                )
                Button(
                    onClick = { navigator.navigate(route = "/quiz") },
                    modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally)
                ) {
                    Text("COMMENCE !!!!")
                }

            }
        }
    }
}