package main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
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
    public T visitExpression(ExpressionContext expressionContext) throws SemanticAnalyzerException {
        return null;
    }

    @Override
    public T visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext) throws SemanticAnalyzerException {
        return null;
    }

    @Override
    public T visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext) throws SemanticAnalyzerException {
        return null;
    }

    @Override
    public T visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext) throws SemanticAnalyzerException {
        return null;
    }

    @Override
    public T visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext) throws SemanticAnalyzerException {
        return null;
    }
}
