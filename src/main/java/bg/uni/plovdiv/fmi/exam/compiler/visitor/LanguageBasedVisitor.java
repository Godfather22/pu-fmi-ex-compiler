package main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;

public class LanguageBasedVisitor<T> implements Visitor<T> {
    @Override
    public T visitProgram(ProgramContext programContext) {
        return null;
    }

    @Override
    public T visitStatement(StatementContext statementContext) {
        return null;
    }

    @Override
    public T visitExpression(ExpressionContext expressionContext) {
        return null;
    }

    @Override
    public T visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext) {
        return null;
    }

    @Override
    public T visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext) {
        return null;
    }

    @Override
    public T visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext) {
        return null;
    }

    @Override
    public T visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext) {
        return null;
    }
}
