package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.List;

public class MultiplicativeExpressionContext extends RuleContext {

    private final List<PrimaryExpressionContext> primaryExpressions;

    public MultiplicativeExpressionContext(List<PrimaryExpressionContext> primaryExpressions) {
        this.primaryExpressions = primaryExpressions;

        for (var pe : primaryExpressions)
            this.addChild(pe);
    }

    public List<PrimaryExpressionContext> getPrimaryExpressions() {
        return primaryExpressions;
    }

    public PrimaryExpressionContext getPrimaryExpression(int i) {
        return primaryExpressions.get(i);
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitMultiplicativeExpression(this);
    }
}
