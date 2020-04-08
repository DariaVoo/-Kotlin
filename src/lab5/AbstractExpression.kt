package lab5

open class AbstractExpression {
    open fun interpret(context: MutableList<String>): MutableList<String> {
        return CompoundExpression().interpret(context)
    }
}