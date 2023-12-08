import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import moe.tlaster.precompose.navigation.Navigator


@Composable
fun ScoreScreen(navigator: Navigator, score: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Card(
            modifier = Modifier.padding(10.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column (
                modifier = Modifier.background(Color.Green).padding(15.dp)
            ) {
                Text(
                    text = "Score :",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally),

                    )
                Text(
                    text = score.toString(),
                    fontSize = 26.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Button(
                    onClick = {navigator.navigate(route = "/quiz")},
                    modifier = Modifier.padding(5.dp).align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null
                    )
                    Text("Recommencer")
                }

            }
        }
    }
}