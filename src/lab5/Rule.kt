package lab5

abstract class Rule(
    val reg: Regex,
    private val replacement: String
): AbstractExpression() {
    override fun interpret(context: MutableList<String>): MutableList<String> {
        return context.map { reg.replace(it, replacement) }.toMutableList()
    }
}

//TerminalExpression
class MultiplieSpaces(): Rule(Regex(""" +"""), " ")
class MultiplieTabs(): Rule(Regex("""\t+"""), "\t")
class DashInsteadHyphen(): Rule(Regex("""-+"""), "—")
class PolygraphicInsteadQuote1(): Rule(Regex("""“+"""), "«")
class PolygraphicInsteadQuote2(): Rule(Regex("""”+"""), "»")
class SpaceBoforePunctuation1(): Rule(Regex("""\(\s"""), "(")
class SpaceBoforePunctuation2(): Rule(Regex("""\s\)"""), ")")
class SpaceBoforePunctuation3(): Rule(Regex("""\s,"""), ",")
class SpaceBoforePunctuation4(): Rule(Regex("""\s\."""), ".")

class MultiplieLineFeed(): Rule(Regex("""\n+"""), "\n") {
    override fun interpret(context: MutableList<String>): MutableList<String> {
        context.removeIf{it == "" || it == "\n"}
        return context
    }
}