package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class MultiplicativeExpressionContext extends RuleContext {

    private final PrimaryExpressionContext firstOperand;
    private PrimaryExpressionContext secondOperand;
    private SpecialSymbol operator;

    public MultiplicativeExpressionContext(PrimaryExpressionContext firstOperand) {
        this.firstOperand = firstOperand;
    }

    public MultiplicativeExpressionContext(PrimaryExpressionContext firstOperand, PrimaryExpressionContext secondOperand, SpecialSymbol operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public PrimaryExpressionContext getFirstOperand() {
        return firstOperand;
    }

    public PrimaryExpressionContext getSecondOperand() {
        return secondOperand;
    }

    public SpecialSymbol getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) throws SemanticAnalyzerException {
        return visitor.visitMultiplicativeExpression(this);
    }
}
