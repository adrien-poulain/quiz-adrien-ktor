import classes.Question
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import network.QuizAPI

class QuizRepository {

    private val quizAPI = QuizAPI()
    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    private val _questionState = MutableStateFlow<List<Question>>(emptyList())
    val questionState: StateFlow<List<Question>> = _questionState

    init {
        updateQuiz()
    }

    private suspend fun fetchQuiz(): List<Question> {
        return quizAPI.getAllQuestions().questions
    }

    private fun updateQuiz() {
        coroutineScope.launch {
            val quiz = fetchQuiz()
            _questionState.emit(quiz)
        }
    }
}


