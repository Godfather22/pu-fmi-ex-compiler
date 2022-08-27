package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class StatementContext extends RuleContext {
    private final ExpressionContext expressionContext;

    public StatementContext(ExpressionContext expressionContext) {
        this.expressionContext = expressionContext;

        // добавяне на листо-дете
        // тъй като един statement може да е празен (т.е. само ";")
        // проверяваме дали expressionContext не е null
        if (expressionContext != null)
            this.addChild(expressionContext);
    }

    public ExpressionContext getExpressionContext() {
        return expressionContext;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitStatement(this);
    }
}
