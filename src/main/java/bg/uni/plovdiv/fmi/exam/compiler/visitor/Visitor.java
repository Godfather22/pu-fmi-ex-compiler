package main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;

public interface Visitor<T> {
    T visitProgram(ProgramContext programContext);
    T visitStatement(StatementContext statementContext);
    T visitExpression(ExpressionContext expressionContext);
    T visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext);
    T visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext);
    T visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext);
    T visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext);
}
