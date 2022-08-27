package main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.concrete;

import main.java.bg.uni.plovdiv.fmi.exam.compiler.enums.SpecialSymbol;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.exception.SemanticAnalyzerException;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.grammar.RuleContext;
import main.java.bg.uni.plovdiv.fmi.exam.compiler.visitor.Visitor;

public class PrimaryExpressionContext extends RuleContext {

    private IdentContext identContext;

    private ExpressionContext expressionContext;
    private PrimaryExpressionContext primaryExpressionContext;

    private NumberContext numberContext;
    private KeywordContext keywordContext;

    private SpecialSymbol binaryOperator, unaryPrefixedOperator, unaryPostfixedOperator, openingBrace, closingBrace;

    public PrimaryExpressionContext(IdentContext identContext, ExpressionContext expressionContext, SpecialSymbol binaryOperator) {
        this.identContext = identContext;
        this.expressionContext = expressionContext;
        this.binaryOperator = binaryOperator;
    }

    public PrimaryExpressionContext(SpecialSymbol unaryPrefixedOperator, PrimaryExpressionContext primaryExpressionContext) {
        this.primaryExpressionContext = primaryExpressionContext;
        this.unaryPrefixedOperator = unaryPrefixedOperator;
    }

    public PrimaryExpressionContext(SpecialSymbol unaryPrefixedOperator, IdentContext identContext) {
        this.identContext = identContext;
        this.unaryPrefixedOperator = unaryPrefixedOperator;
    }

    public PrimaryExpressionContext(IdentContext identContext, SpecialSymbol unaryPostfixedOperator) {
        this.identContext = identContext;
        this.unaryPostfixedOperator = unaryPostfixedOperator;
    }

    public PrimaryExpressionContext(IdentContext identContext) {
        this.identContext = identContext;
    }

    public PrimaryExpressionContext(NumberContext numberContext) {
        this.numberContext = numberContext;
    }

    public PrimaryExpressionContext(KeywordContext keywordContext) {
        this.keywordContext = keywordContext;
    }

    public PrimaryExpressionContext(SpecialSymbol openingBrace, ExpressionContext expressionContext, SpecialSymbol closingBrace) {
        this.expressionContext = expressionContext;
        this.openingBrace = openingBrace;
        this.closingBrace = closingBrace;
    }

    public IdentContext getIdentContext() {
        return identContext;
    }

    public ExpressionContext getExpressionContext() {
        return expressionContext;
    }

    public PrimaryExpressionContext getPrimaryExpressionContext() {
        return primaryExpressionContext;
    }

    public NumberContext getNumberContext() {
        return numberContext;
    }

    public KeywordContext getKeywordContext() {
        return keywordContext;
    }

    public SpecialSymbol getBinaryOperator() {
        return binaryOperator;
    }

    public SpecialSymbol getUnaryPrefixedOperator() {
        return unaryPrefixedOperator;
    }

    public SpecialSymbol getUnaryPostfixedOperator() {
        return unaryPostfixedOperator;
    }

    public SpecialSymbol getOpeningBrace() {
        return openingBrace;
    }

    public SpecialSymbol getClosingBrace() {
        return closingBrace;
    }

    @Override
    public <T> T accept(Visitor<? extends T> visitor) throws SemanticAnalyzerException {
        return visitor.visitPrimaryExpression(this);
    }
}
