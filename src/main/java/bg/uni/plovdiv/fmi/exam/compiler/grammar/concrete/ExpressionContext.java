package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class ExpressionContext extends RuleContext {

    private final BitwiseAndExpressionContext firstOperand;
    private BitwiseAndExpressionContext secondOperand;
    private SpecialSymbol operator;

    public ExpressionContext(BitwiseAndExpressionContext firstOperand) {
        this.firstOperand = firstOperand;

        this.addChild(firstOperand);
    }

    public ExpressionContext(BitwiseAndExpressionContext firstOperand,
                             BitwiseAndExpressionContext secondOperand,
                             SpecialSymbol operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;

        this.addChild(firstOperand);
        this.addChild(secondOperand);
    }

    public BitwiseAndExpressionContext getFirstOperand() {
        return firstOperand;
    }

    public BitwiseAndExpressionContext getSecondOperand() {
        return secondOperand;
    }

    public SpecialSymbol getOperator() {
        return operator;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) throws SemanticAnalyzerException {
        return visitor.visitExpression(this);
    }
}
