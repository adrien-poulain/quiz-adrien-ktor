package network

import classes.Quiz
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class QuizAPI {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                contentType = ContentType.Text.Plain,
                json = Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
        }
    }
    suspend fun getAllQuestions(): Quiz {
        return httpClient.get("https://github.com/worldline/learning-kotlin-multiplatform/raw/main/quiz.json").body()
    }
}
