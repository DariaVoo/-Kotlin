package lab5

class CompoundExpression: AbstractExpression() {
    private val rules = listOf<Rule>(
        MultiplieSpaces(),
        MultiplieTabs(),
        MultiplieLineFeed(),
        DashInsteadHyphen(),
        PolygraphicInsteadQuote1(),
        PolygraphicInsteadQuote2(),
        SpaceBoforePunctuation1(),
        SpaceBoforePunctuation2(),
        SpaceBoforePunctuation3(),
        SpaceBoforePunctuation4()
    )

    override fun interpret(context: MutableList<String>): MutableList<String> {
        var ans = context
        for (r in rules)
            ans = r.interpret(ans)
        return ans
    }

}