package main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.*;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.DelimiterContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.IdentContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.KeywordContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete.lexeme.NumberContext;

public interface Visitor<T> {
    T visitProgram(ProgramContext programContext);
    T visitStatement(StatementContext statementContext);
    T visitExpression(ExpressionContext expressionContext) throws SemanticAnalyzerException;
    T visitBitwiseAndExpression(BitwiseAndExpressionContext bitwiseAndExpressionContext) throws SemanticAnalyzerException;
    T visitAdditiveExpression(AdditiveExpressionContext additiveExpressionContext) throws SemanticAnalyzerException;
    T visitMultiplicativeExpression(MultiplicativeExpressionContext multiplicativeExpressionContext) throws SemanticAnalyzerException;
    T visitPrimaryExpression(PrimaryExpressionContext primaryExpressionContext) throws SemanticAnalyzerException;

    T visitNumber(NumberContext numberContext) throws SemanticAnalyzerException;
    T visitIdentifier(IdentContext identContext) throws SemanticAnalyzerException;
    T visitDelimiter(DelimiterContext delimiterContext) throws SemanticAnalyzerException;
    T visitKeyword(KeywordContext keywordContext) throws SemanticAnalyzerException;

}
