package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

import java.util.List;

public class AdditiveExpressionContext extends RuleContext {

    private final List<MultiplicativeExpressionContext> multiplicativeExpressions;

    public AdditiveExpressionContext(List<MultiplicativeExpressionContext> multiplicativeExpressions) {
        this.multiplicativeExpressions = multiplicativeExpressions;

        for (var me : multiplicativeExpressions)
            this.addChild(me);
    }

    public List<MultiplicativeExpressionContext> getMultiplicativeExpressions() {
        return this.multiplicativeExpressions;
    }

    public MultiplicativeExpressionContext getMultiplicativeExpression(int i) {
        return this.multiplicativeExpressions.get(i);
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitAdditiveExpression(this);
    }
}
