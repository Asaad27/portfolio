import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.theme.AsaadTheme

@Composable
fun AsaadEntry() {
    AsaadTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text("hello Asaad")
                Text("hello Asaad in title large", style = MaterialTheme.typography.titleLarge)
            }
        }

    }
}