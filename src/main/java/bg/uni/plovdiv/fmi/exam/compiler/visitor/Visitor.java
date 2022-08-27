package main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;

public interface Visitor<T> {
    T visitProgram(ProgramContext programContext);
    T visitStatement(StatementContext statementContext);
    T visitExpression(ExpressionContext expressionContext) throws SemanticAnalyzerException;
    T visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext) throws SemanticAnalyzerException;
    T visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext) throws SemanticAnalyzerException;
    T visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext) throws SemanticAnalyzerException;
    T visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext) throws SemanticAnalyzerException;
}
