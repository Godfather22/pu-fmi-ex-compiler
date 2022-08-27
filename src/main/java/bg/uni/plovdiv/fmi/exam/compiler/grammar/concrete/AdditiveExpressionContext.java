package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class AdditiveExpressionContext extends RuleContext {

    private final MultiplicativeExpressionContext firstOperand;
    private  MultiplicativeExpressionContext secondOperand;
    private SpecialSymbol operator;

    public AdditiveExpressionContext(MultiplicativeExpressionContext firstOperand) {
        this.firstOperand = firstOperand;
    }

    public AdditiveExpressionContext(MultiplicativeExpressionContext firstOperand, MultiplicativeExpressionContext secondOperand, SpecialSymbol operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public MultiplicativeExpressionContext getFirstOperand() {
        return firstOperand;
    }

    public MultiplicativeExpressionContext getSecondOperand() {
        return secondOperand;
    }

    public SpecialSymbol getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitAdditiveExpression(this);
    }
}
