package lab5

import java.io.File

fun getContext(fileName: String): List<String> = File(fileName).readLines()
fun saveContext(fileName: String, context: List<String>) {
    val file = File(fileName).bufferedWriter()
    for (str in context) {
        file.write(str)
        file.write("\n")
    }
    file.close()
}

fun main(args: Array<String>) {
    val context = getContext("src//lab5//input.txt").toMutableList()
    saveContext("src//lab5//out.txt", AbstractExpression().interpret(context))
}