import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import classes.Question
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun QuestionScreen(navigator: Navigator, questions : List<Question>) {

    var questionProgress by remember { mutableStateOf(0) }
    var selectAnswer by remember { mutableStateOf(1) }
    var finalScore by remember { mutableStateOf(0) }

    Column (
        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
        ) {
            Card {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = questions[questionProgress].label,
                        fontSize = 18.sp
                    )
                }
            }
            Column {
                questions[questionProgress].answers.forEach { answer ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectAnswer == answer.id,
                            onClick = { selectAnswer = answer.id }
                        )
                        Text(answer.label)
                    }
                }
            }
        }
        Column {
            Button(
                onClick = {
                    if (selectAnswer == questions[questionProgress].correctAnswerId) {
                        finalScore = finalScore + 1
                    }
                    if (questionProgress < questions.size - 1) {
                        questionProgress = questionProgress + 1
                        selectAnswer = 1
                    }else {
                        navigator.navigate("/score/$finalScore out of ${questions.size}")
                    }
                }
            ) {
                Text("Suivant")
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
        LinearProgressIndicator(
            progress = (questionProgress.toFloat() / questions.size.toFloat()),
            color = Color.Blue,
            modifier = Modifier
                .height(10.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        )
    }
}