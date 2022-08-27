package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.List;

public class ExpressionContext extends RuleContext {

    private final List<BitwiseAndExpressionContext> bitwiseAndExpressions;

    public ExpressionContext(List<BitwiseAndExpressionContext> bitwiseAndExpressions) {
        this.bitwiseAndExpressions = bitwiseAndExpressions;

        for (var bae : bitwiseAndExpressions)
            this.addChild(bae);
    }

    public List<BitwiseAndExpressionContext> getBitwiseAndExpressions() {
        return bitwiseAndExpressions;
    }

    public BitwiseAndExpressionContext getBitwiseAndExpression(int i) {
        return bitwiseAndExpressions.get(i);
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitExpression(this);
    }
}
