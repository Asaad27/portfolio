package data

sealed class FileNode(var name: String) {

    class File(name: String, var level: Int) : FileNode(name)

    class Directory(name: String, var level: Int, var children: MutableList<FileNode> = mutableListOf()) :
            FileNode(name)
}