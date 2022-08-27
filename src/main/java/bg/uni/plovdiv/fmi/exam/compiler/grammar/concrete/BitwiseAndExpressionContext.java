package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class BitwiseAndExpressionContext extends RuleContext {

    private final AdditiveExpressionContext firstOperand;
    private AdditiveExpressionContext secondOperand;
    private SpecialSymbol operator;

    public BitwiseAndExpressionContext(AdditiveExpressionContext firstOperand) {
        this.firstOperand = firstOperand;
    }

    public BitwiseAndExpressionContext(AdditiveExpressionContext firstOperand, AdditiveExpressionContext secondOperand, SpecialSymbol operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public AdditiveExpressionContext getFirstOperand() {
        return firstOperand;
    }

    public AdditiveExpressionContext getSecondOperand() {
        return secondOperand;
    }

    public SpecialSymbol getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) {
        return visitor.visitBitwiseAndExpression(this);
    }

}
