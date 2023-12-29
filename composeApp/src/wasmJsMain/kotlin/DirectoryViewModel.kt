import data.FileNode
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DirectoryViewModel {
    
    private val _fileNodeStates: MutableStateFlow<Map<FileNode, FileNodeState>> = MutableStateFlow(emptyMap())
    val fileNodeState: StateFlow<Map<FileNode, FileNodeState>> = _fileNodeStates.asStateFlow()
    val rootNode: FileNode

    init {
        rootNode = createNestedStructure(FileNode.Directory("Root", 0), 0, 10)
    }
    
    fun onDirectoryClick(node: FileNode) {
        val currentState = _fileNodeStates.value[node] ?: FileNodeState()
        updateNodeState(node, isOpened = !currentState.isOpened)
    }

    //todo: handle later file opening in the other tabs
    fun onFileClick(fileNode: FileNode.File) {
        val currentState = _fileNodeStates.value[fileNode] ?: FileNodeState()
        updateNodeState(fileNode, isOpened = !currentState.isOpened)
    }
    
    private fun updateNodeState(node: FileNode, isOpened: Boolean? = null, isFocused: Boolean? = null) {
        val currentState = _fileNodeStates.value[node] ?: FileNodeState()
        val newState = currentState.copy(
            isOpened = isOpened ?: currentState.isOpened,
            isFocused = isFocused ?: currentState.isFocused
        )
        _fileNodeStates.value += (node to newState)
    }
    
    
    private fun addNode(node: FileNode, state: FileNodeState = FileNodeState()) {
        _fileNodeStates.value += (node to state)
    }
    
    private fun createNestedStructure(node: FileNode, currentLevel: Int, maxLevel: Int): FileNode {
        if (currentLevel >= maxLevel || node is FileNode.File) {
            return node.also { addNode(it) }
        }

        if (node is FileNode.Directory) {
            node.children.add(createNestedStructure(FileNode.Directory("Subdirectory1 L${currentLevel + 1}", currentLevel + 1), currentLevel + 1, maxLevel))
            node.children.add(createNestedStructure(FileNode.Directory("Subdirectory2 L${currentLevel + 1}", currentLevel + 1), currentLevel + 1, maxLevel))
            node.children.add(FileNode.File("File L${currentLevel + 1} in ${node.name}", currentLevel + 1))
        }

        return node.also { addNode(it) }
    }

}


data class FileNodeState(
    val isOpened: Boolean = false,
    val isFocused: Boolean = false
)