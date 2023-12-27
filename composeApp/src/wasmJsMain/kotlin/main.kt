import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow(title = "Asaad27", canvasElementId = "ComposeTarget") {
        var isLoading by remember { mutableStateOf(true) }

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            AsaadEntry()
        }

        LaunchedEffect(Unit) {
            loadJetbrainsMonoFont()
            isLoading = false
        }
    }
}


private suspend fun loadJetbrainsMonoFont(): FontFamily {
    val regular = loadResource("fonts/jetbrains_mono/ttf/JetBrainsMono-Regular.ttf")
    val medium = loadResource("fonts/jetbrains_mono/ttf/JetBrainsMono-Medium.ttf")
    val light = loadResource("fonts/jetbrains_mono/ttf/JetBrainsMono-Light.ttf")
    val semiBold = loadResource("fonts/jetbrains_mono/ttf/JetBrainsMono-SemiBold.ttf")
    val bold = loadResource("fonts/jetbrains_mono/ttf/JetBrainsMono-Bold.ttf")

    return FontFamily(
        Font(identity = "JetbrainsMonoRegular", data = regular, weight = FontWeight.Normal),
        Font(identity = "JetbrainsMonoMedium", data = medium, weight = FontWeight.Medium),
        Font(identity = "JetbrainsMonoLight", data = light, weight = FontWeight.Light),
        Font(identity = "JetbrainsMonoSemiBold", data = semiBold, weight = FontWeight.SemiBold),
        Font(identity = "JetbrainsMonoBold", data = bold, weight = FontWeight.Bold),
    )
}

@OptIn(ExperimentalResourceApi::class, ExperimentalResourceApi::class)
internal suspend fun loadResource(resourcePath: String): ByteArray {
    return resource(resourcePath).readBytes()
}