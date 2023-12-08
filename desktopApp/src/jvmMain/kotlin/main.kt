import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import moe.tlaster.precompose.PreComposeWindow

fun main() = application { // kotlin application
    PreComposeWindow(onCloseRequest = ::exitApplication, title = "QuizzApp") {
        MainView()
    }
}