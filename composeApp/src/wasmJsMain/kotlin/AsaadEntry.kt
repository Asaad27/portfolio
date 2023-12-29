import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import data.FileNode
import ui.theme.AsaadTheme

@Composable
fun AsaadEntry() {
    val viewModel = DirectoryViewModel()

    AsaadTheme(useDarkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Row {
                DirectoryWindow(
                    modifier = Modifier
                        .fillMaxHeight()
                        .requiredWidth(300.dp),
                    rootNode = viewModel.rootNode,
                    viewModel = viewModel
                )

                EditorWindow(
                    modifier = Modifier.fillMaxSize()
                )
            }

        }

    }
}

@Composable
fun DisplayDirectoryContent(
    node: FileNode.Directory,
    viewModel: DirectoryViewModel,
) {
    val fileNodeStates by viewModel.fileNodeState.collectAsState()

    val indentModifier = remember(node.level) { Modifier.padding(start = (node.level * 10).dp) }
    val nodeState = fileNodeStates[node] ?: FileNodeState()

    DirectoryItem(
        directory = node,
        onDirectoryClick = { viewModel.onDirectoryClick(node) },
        isOpened = nodeState.isOpened,
        modifier = indentModifier
    )

    if (nodeState.isOpened) {
        node.children.forEach { childNode ->
            if (childNode is FileNode.Directory) {
                DisplayDirectoryContent(childNode, viewModel)
            } else if (childNode is FileNode.File) {
                FileItem(
                    modifier = indentModifier,
                    file = childNode,
                    icon = Icons.Default.Favorite,
                    onFileClick = { viewModel.onFileClick(childNode) }
                )
            }
        }
    }

}

@Composable
fun DirectoryWindow(
    modifier: Modifier = Modifier,
    rootNode: FileNode,
    viewModel: DirectoryViewModel,
) {
    Column(
        modifier = modifier
            .border(width = 1.dp, color = Color.Black)
            .verticalScroll(rememberScrollState())
    ) {
        DisplayDirectoryContent(
            node = rootNode as FileNode.Directory,
            viewModel = viewModel
        )
    }
}


@Composable
fun DirectoryItem(
    modifier: Modifier = Modifier,
    directory: FileNode.Directory,
    onDirectoryClick: () -> Unit,
    isOpened: Boolean,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onDirectoryClick)
            .padding(vertical = 4.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = if (isOpened) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowRight,
            contentDescription = "Toggle directory",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = directory.name, style = MaterialTheme.typography.bodyMedium)

    }
}

@Composable
fun FileItem(
    modifier: Modifier = Modifier,
    file: FileNode.File,
    onFileClick: () -> Unit,
    icon: ImageVector
) {
    Row(
        modifier = modifier
            .clickable(onClick = onFileClick)
            .padding(vertical = 4.dp, horizontal = 28.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon,
            contentDescription = "File icon",
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = file.name, style = MaterialTheme.typography.bodySmall)
    }

}

@Composable
fun EditorWindow(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
    }
}