package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.List;

public class BitwiseAndExpressionContext extends RuleContext {

    private final List<AdditiveExpressionContext> additiveExpressions;

    public BitwiseAndExpressionContext(List<AdditiveExpressionContext> additiveExpressions) {
        this.additiveExpressions = additiveExpressions;

        for (var ae : additiveExpressions)
            this.addChild(ae);
    }

    public List<AdditiveExpressionContext> getAdditiveExpressions() {
        return additiveExpressions;
    }

    public AdditiveExpressionContext getAdditiveExpression(int i) {
        return additiveExpressions.get(i);
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitBitwiseAndExpression(this);
    }

}
