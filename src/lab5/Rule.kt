package lab5

abstract class Rule(
    val reg: Regex,
    private val replacement: String
): AbstractExpression() {
    override fun interpret(context: MutableList<String>): MutableList<String> {
        return context.map { reg.replace(it, replacement) }.toMutableList()
    }
}
