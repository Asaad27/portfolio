import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ui.theme.AsaadTheme

@Composable
fun AsaadEntry() {
    AsaadTheme {
       Column {
          Text("hello Asaad")
          Text("hello Asaad in title large", style = MaterialTheme.typography.titleLarge)
       }
       
    }
}